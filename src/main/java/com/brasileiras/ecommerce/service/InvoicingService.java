package com.brasileiras.service;

import com.brasileiras.model.Invoicing;
import java.util.List;

public interface InvoicingService {
    List<Invoicing> findAll();
    Invoicing findById(Long id);
    Invoicing save(Invoicing invoicing);
    void updateStock(Long invoicingId, int quantity);
    void delete(Long id);
}
