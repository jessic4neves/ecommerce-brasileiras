package com.brasileiras.controller;

import com.brasileiras.model.Invoicing;
import com.brasileiras.service.InvoicingService;
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
        return invoicingService.getAll();
    }

    @GetMapping("/{id}")
    public Invoicing getById(@PathVariable Long id) {
        return invoicingService.getById(id);
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
