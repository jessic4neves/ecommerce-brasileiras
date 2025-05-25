package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Invoicing;
import com.brasileiras.ecommerce.service.InvoicingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoicing")
public class InvoicingController {
    private final InvoicingService invoicingService;

    public InvoicingController(InvoicingService invoicingService) {
        this.invoicingService = invoicingService;
    }

    @GetMapping
    public List<Invoicing> getAll() {
        return invoicingService.findAll();
    }

    @GetMapping("/{id}")
    public Invoicing getById(@PathVariable Long id) {
        return invoicingService.findById(id);
    }
    
    @PutMapping
    public void update(@PathVariable Long id, @RequestBody Invoicing invoicing) {
        invoicingService.update(id, invoicing);
    }

    @PostMapping
    public Invoicing save(@RequestBody Invoicing invoicing) {
        return invoicingService.save(invoicing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        invoicingService.delete(id);
    }
}
