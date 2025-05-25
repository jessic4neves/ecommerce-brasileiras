package com.brasileiras.service;

import com.brasileiras.model.Supplier;
import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();
    Supplier findById(Long id);
    Supplier save(Supplier supplier);
    void update(Long accountReceiveId, Supplier supplier);
    void delete(Long id);
}
