package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.*;
import com.brasileiras.ecommerce.model.enums.PaymentMethod;
import com.brasileiras.ecommerce.model.enums.AccountStatus;
import com.brasileiras.ecommerce.model.enums.DeliveryStatus;
import com.brasileiras.ecommerce.repository.*;
import com.brasileiras.ecommerce.service.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.brasileiras.ecommerce.model.enums.DeliveryEventStatus;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final AccountReceivableRepository accountReceivableRepository;

    @Override
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    @Override
    public void delete(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale update(Long id, Sale sale) {
        Sale existingSale = findById(id);
        existingSale.setDate(sale.getDate());
        existingSale.setDeliveryStatus(sale.getDeliveryStatus());
        return saleRepository.save(existingSale);
    }

    public SaleServiceImpl(SaleRepository saleRepository, ProductRepository productRepository,
                            UserRepository userRepository, AddressRepository addressRepository,
                            AccountReceivableRepository accountReceivableRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.accountReceivableRepository = accountReceivableRepository;
    }

    @Override
    @Transactional
    public Sale finalizeSale(Sale sale) {
        User user = userRepository.findById(sale.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Address address = addressRepository.findById(sale.getDeliveryAddress().getId())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        if (!address.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Address does not belong to the user");
        }

        sale.setUser(user);
        sale.setDeliveryAddress(address);
        sale.setDate(LocalDateTime.now());
        sale.setDeliveryStatus(DeliveryStatus.PROCESSING);

        for (SaleItem item : sale.getItems()) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getDescription());
            }

            item.setUnitPrice(product.getSalePrice());
            item.setTotalPrice(product.getSalePrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            item.setProduct(product);
            item.setSale(sale);

            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        }

        BigDecimal totalSale = sale.getItems().stream()
                .map(SaleItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPayments = sale.getPayments().stream()
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalPayments.compareTo(totalSale) != 0) {
            throw new RuntimeException("Total payments do not match the sale amount");
        }

        for (Payment payment : sale.getPayments()) {
            payment.setSale(sale);
        }

        Sale savedSale = saleRepository.save(sale);

        generateAccountsReceivable(savedSale);
        startDeliveryProcess(savedSale);

        return savedSale;
    }

    private void generateAccountsReceivable(Sale sale) {
        for (Payment payment : sale.getPayments()) {
            if (payment.getPaymentMethod() == PaymentMethod.CREDIT_CARD ||
                payment.getPaymentMethod() == PaymentMethod.INSTALLMENT) {
                for (int i = 1; i <= payment.getParcels(); i++) {
                    AccountReceive account = new AccountReceive();
                    account.setSale(sale);
                    account.setValue(payment.getValue().divide(
                            BigDecimal.valueOf(payment.getParcels())));
                    account.setPaymentDay(LocalDate.now().plusMonths(i));
                    account.setStatus(AccountStatus.PENDING);
                    accountReceivableRepository.save(account);
                }
            } else {
                AccountReceive account = new AccountReceive();
                account.setSale(sale);
                account.setValue(payment.getAmount());
                account.setDueDate(LocalDate.now());
                account.setInstallmentNumber(1);
                account.setTotalInstallments(1);
                account.setStatus(AccountStatus.PENDING);
                accountReceivableRepository.save(account);
            }
        }
    }

    private void startDeliveryProcess(Sale sale) {
        TrackDelivery tracking = new TrackDelivery();
        tracking.setSale(sale);
        tracking.setTrackingCode(generateTrackingCode());
        tracking.setDeliveryAttempts(0);

        TrackDelivery event = new TrackDelivery();
        event.setDateTime(LocalDateTime.now());
        event.setDescription("Order received and processing");
        event.setStatus(DeliveryEventStatus.COLLECTED);

        tracking.setEvents(List.of(event));
        sale.setTracking(tracking);
        saleRepository.save(sale);
    }

    private String generateTrackingCode() {
        return "BR" + System.currentTimeMillis();
    }
}
