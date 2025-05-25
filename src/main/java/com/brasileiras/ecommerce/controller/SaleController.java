package com.brasileiras.controller;

import com.brasileiras.model.Sale;
import com.brasileiras.service.SaleService;
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
        return saleService.getAll();
    }

    @GetMapping("/{id}")
    public Sale getById(@PathVariable Long id) {
        return saleService.getById(id);
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
