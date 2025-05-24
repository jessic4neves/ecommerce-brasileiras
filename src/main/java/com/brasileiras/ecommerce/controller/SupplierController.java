package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Supplier;
import com.brasileiras.ecommerce.repository.SupplierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierRepository repository;

    public SupplierController(SupplierRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Supplier> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return repository.save(Supplier);
    }
}
