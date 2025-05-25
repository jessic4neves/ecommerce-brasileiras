package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.InvoicingItem;
import java.util.List;

public interface InvoicingItemService {
    List<InvoicingItem> findAll();
    InvoicingItem findById(Long id);
    InvoicingItem save(InvoicingItem invoicingItem);
    void update(Long accountReceiveId, InvoicingItem invoicingItem);
    void delete(Long id);
}
