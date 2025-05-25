package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.Invoicing;
import com.brasileiras.ecommerce.repository.InvoicingRepository;
import com.brasileiras.ecommerce.service.InvoicingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoicingServiceImpl implements InvoicingService {
    private final InvoicingRepository invoicingRepository;

    public InvoicingServiceImpl(InvoicingRepository invoicingRepository) {
        this.invoicingRepository = invoicingRepository;
    }

    @Override
    public List<Invoicing> findAll() {
        return invoicingRepository.findAll();
    }

    @Override
    public Invoicing findById(Long id) {
        return invoicingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoicing not found"));
    }

    @Override
    public Invoicing save(Invoicing invoicing) {
        return invoicingRepository.save(invoicing);
    }

    @Override
    public void update(Long invoicingEventId, InvoicingEvent invoicingEvent) {
        InvoicingEvent invoicingEvent = findById(invoicingEventId);
        invoicingEventRepository.save(invoicingEvent);
    } 

    @Override
    public void delete(Long id) {
        invoicingRepository.deleteById(id);
    }
}
