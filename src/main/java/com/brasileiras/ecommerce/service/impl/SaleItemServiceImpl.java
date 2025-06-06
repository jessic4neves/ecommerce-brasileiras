package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.SaleItem;
import com.brasileiras.ecommerce.repository.SaleItemRepository;
import com.brasileiras.ecommerce.service.SaleItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemServiceImpl implements SaleItemService {
    private final SaleItemRepository saleItemRepository;

    public SaleItemServiceImpl(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    @Override
    public List<SaleItem> findAll() {
        return saleItemRepository.findAll();
    }

    @Override
    public SaleItem findById(Long id) {
        return saleItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SaleItem not found"));
    }

    @Override
    public SaleItem save(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }

    @Override
    public void update(Long saleItemId, SaleItem saleItem) {
        SaleItem existingSaleItem = findById(saleItemId);

        existingSaleItem.setSale(saleItem.getSale());
        existingSaleItem.setProduct(saleItem.getProduct());
        existingSaleItem.setQuantity(saleItem.getQuantity());
        existingSaleItem.setUnitPrice(saleItem.getUnitPrice());
        existingSaleItem.setTotalPrice(saleItem.getTotalPrice());

        saleItemRepository.save(existingSaleItem);
    }

    @Override
    public void delete(Long id) {
        saleItemRepository.deleteById(id);
    }
}
