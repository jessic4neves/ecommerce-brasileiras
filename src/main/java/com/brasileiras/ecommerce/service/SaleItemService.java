package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.SaleItem;
import java.util.List;

public interface SaleItemService {
    List<SaleItem> findAll();
    SaleItem findById(Long id);
    SaleItem save(SaleItem saleItem);
    void update(Long accountReceiveId, SaleItem saleItem);
    void delete(Long id);
}
