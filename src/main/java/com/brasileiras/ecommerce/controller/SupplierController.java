package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Supplier;
import com.brasileiras.ecommerce.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Long id) {
        return supplierService.getById(id);
    }

    @PutMapping
    public Supplier update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.update(id, supplier);
    }

    @PostMapping
    public Supplier save(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        supplierService.delete(id);
    }
}
