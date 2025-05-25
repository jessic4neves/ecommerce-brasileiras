package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.Invoicing;
import java.util.List;

public interface InvoicingService {
    List<Invoicing> findAll();
    Invoicing findById(Long id);
    Invoicing save(Invoicing invoicing);
    void update(Long accountReceiveId, Invoicing invoicing);
    void delete(Long id);
}
