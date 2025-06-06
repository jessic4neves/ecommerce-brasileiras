package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.SaleItem;
import com.brasileiras.ecommerce.service.SaleItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale-item")
public class SaleItemController {
    private final SaleItemService saleItemService;

    public SaleItemController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping
    public List<SaleItem> getAll() {
        return saleItemService.findAll();
    }

    @GetMapping("/{id}")
    public SaleItem getById(@PathVariable Long id) {
        return saleItemService.findById(id);
    }

    @PutMapping
    public void update(@PathVariable Long id, @RequestBody SaleItem saleItem) {
        saleItemService.update(id, saleItem);
    }

    @PostMapping
    public SaleItem save(@RequestBody SaleItem saleItem) {
        return saleItemService.save(saleItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        saleItemService.delete(id);
    }
}
