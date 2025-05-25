package com.brasileiras.service;

import com.brasileiras.model.Sale;
import java.util.List;

public interface SaleService {
    List<Sale> findAll();
    Sale findById(Long id);
    Sale save(Sale sale);
    void updateStock(Long saleId, int quantity);
    void delete(Long id);
}
