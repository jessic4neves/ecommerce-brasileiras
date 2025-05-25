package com.brasileiras.service;

import com.brasileiras.model.InvoicingItem;
import java.util.List;

public interface InvoicingItemService {
    List<InvoicingItem> findAll();
    InvoicingItem findById(Long id);
    InvoicingItem save(InvoicingItem invoicingItem);
    void updateStock(Long invoicingItemId, int quantity);
    void delete(Long id);
}
