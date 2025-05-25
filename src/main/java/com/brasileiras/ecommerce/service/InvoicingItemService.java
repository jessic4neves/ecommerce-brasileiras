package com.brasileiras.service;

import com.brasileiras.model.InvoicingItem;
import java.util.List;

public interface InvoicingItemService {
    List<InvoicingItem> findAll();
    InvoicingItem findById(Long id);
    InvoicingItem save(InvoicingItem invoicingItem);
    void update(Long accountReceiveId, InvoicingItem invoicingItem);
    void delete(Long id);
}
