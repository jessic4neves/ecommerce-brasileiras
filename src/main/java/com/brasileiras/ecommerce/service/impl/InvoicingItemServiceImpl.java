package com.brasileiras.service.impl;

import com.brasileiras.model.InvoicingItem;
import com.brasileiras.repository.InvoicingItemRepository;
import com.brasileiras.service.InvoicingItemService;
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
    public void update(Long invoicingItemEventId, InvoicingItemEvent invoicingItemEvent) {
        invoicingItemEvent invoicingItemEvent = findById(invoicingItemEventId);
        invoicingItemEventRepository.save(invoicingItemEvent);
    } 

    @Override
    public void delete(Long id) {
        invoicingItemRepository.deleteById(id);
    }
}
