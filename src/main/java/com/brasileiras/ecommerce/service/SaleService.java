package com.brasileiras.service;

import com.brasileiras.model.Sale;
import java.util.List;

public interface SaleService {
    List<Sale> findAll();
    Sale findById(Long id);
    Sale save(Sale sale);
    void update(Long accountReceiveId, Sale sale);
    void delete(Long id);
}
