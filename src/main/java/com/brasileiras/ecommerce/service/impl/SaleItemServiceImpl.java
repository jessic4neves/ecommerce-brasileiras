package com.brasileiras.service.impl;

import com.brasileiras.model.SaleItem;
import com.brasileiras.repository.SaleItemRepository;
import com.brasileiras.service.SaleItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public SaleItem save(SaleItem SaleItem) {
        return saleItemRepository.save(saleItem);
    }

    @Override
    @Transactional
    public void updateStock(Long saleItemId, int quantity) {
        SaleItem saleItem = findById(saleItemId);
        saleItem.setEstoque(saleItem.getEstoque() + quantity);
        saleItemRepository.save(saleItem);
    }

    @Override
    public void delete(Long id) {
        saleItemRepository.deleteById(id);
    }
}
