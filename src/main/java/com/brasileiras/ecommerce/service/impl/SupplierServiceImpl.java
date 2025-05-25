package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.Supplier;
import com.brasileiras.ecommerce.repository.SupplierRepository;
import com.brasileiras.ecommerce.service.SupplierService;
import org.springframework.stereotype.Service;

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
        Supplier existingSupplier = findById(supplierId);

        existingSupplier.setCompanyName(supplier.getCompanyName());
        existingSupplier.setCnpj(supplier.getCnpj());
        existingSupplier.setStateRegistration(supplier.getStateRegistration());
        existingSupplier.setPhone(supplier.getPhone());
        existingSupplier.setEmail(supplier.getEmail());

        supplierRepository.save(existingSupplier);
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}
