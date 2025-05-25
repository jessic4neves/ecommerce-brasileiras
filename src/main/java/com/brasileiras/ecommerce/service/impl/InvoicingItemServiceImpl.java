package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.InvoicingItem;
import com.brasileiras.ecommerce.repository.InvoicingItemRepository;
import com.brasileiras.ecommerce.service.InvoicingItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoicingItemServiceImpl implements InvoicingItemService {
    private final InvoicingItemRepository invoicingItemRepository;

    public InvoicingItemServiceImpl(InvoicingItemRepository invoicingItemRepository) {
        this.invoicingItemRepository = invoicingItemRepository;
    }

    @Override
    public List<InvoicingItem> findAll() {
        return invoicingItemRepository.findAll();
    }

    @Override
    public InvoicingItem findById(Long id) {
        return invoicingItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InvoicingItem not found"));
    }

    @Override
    public InvoicingItem save(InvoicingItem invoicingItem) {
        return invoicingItemRepository.save(invoicingItem);
    }

    @Override
    public void update(Long invoicingItemId, InvoicingItemEvent invoicingItem) {
        InvoicingItemEvent existingItem = findById(invoicingItemId);

        existingItem.setInvoicing(invoicingItem.getInvoicing());
        existingItem.setProduct(invoicingItem.getProduct());
        existingItem.setQuantity(invoicingItem.getQuantity());
        existingItem.setUnitaryValue(invoicingItem.getUnitaryValue());
        existingItem.setTotalValue(invoicingItem.getTotalValue());

        invoicingItemRepository.save(existingItem);
    }

    @Override
    public void delete(Long id) {
        invoicingItemRepository.deleteById(id);
    }
}
