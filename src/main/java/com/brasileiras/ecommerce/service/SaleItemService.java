package com.brasileiras.service;

import com.brasileiras.model.SaleItem;
import java.util.List;

public interface SaleItemService {
    List<SaleItem> findAll();
    SaleItem findById(Long id);
    SaleItem save(SaleItem saleItem);
    void updateStock(Long saleItemId, int quantity);
    void delete(Long id);
}
