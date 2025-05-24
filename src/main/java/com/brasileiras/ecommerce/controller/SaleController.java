package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Sale;
import com.brasileiras.ecommerce.repository.SaleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleRepository repository;

    public SaleController(SaleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Sale> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public Sale create(@RequestBody Sale sale) {
        return repository.save(sale);
    }
}
