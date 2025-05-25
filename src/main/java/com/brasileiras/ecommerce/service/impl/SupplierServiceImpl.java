package com.brasileiras.service.impl;

import com.brasileiras.model.Supplier;
import com.brasileiras.repository.SupplierRepository;
import com.brasileiras.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void update(Long supplierId, Supplier supplier) {
        supplier supplier = findById(supplierId);
        supplierRepository.save(supplier);
    } 

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}
