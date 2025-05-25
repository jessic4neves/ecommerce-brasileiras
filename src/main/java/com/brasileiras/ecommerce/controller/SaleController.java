package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Sale;
import com.brasileiras.ecommerce.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<Sale> getAll() {
        return saleService.findAll();
    }

    @GetMapping("/{id}")
    public Sale getById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    @PutMapping
    public void update(@PathVariable Long id, @RequestBody Sale sale) {
        saleService.update(id, sale);
    }

    @PostMapping
    public Sale save(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        saleService.delete(id);
    }
}
