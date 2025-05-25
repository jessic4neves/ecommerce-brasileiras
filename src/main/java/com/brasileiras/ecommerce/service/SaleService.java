package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.Sale;
import java.util.List;

public interface SaleService {
    List<Sale> findAll();
    Sale findById(Long id);
    Sale save(Sale sale);
    Sale update(Long accountReceiveId, Sale sale);
    void delete(Long id);
}
