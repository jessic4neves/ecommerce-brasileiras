package com.brasileiras.controller;

import com.brasileiras.model.SaleItem;
import com.brasileiras.service.SaleItemService;
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
        return saleItemService.getAll();
    }

    @GetMapping("/{id}")
    public SaleItem getById(@PathVariable Long id) {
        return saleItemService.getById(id);
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
