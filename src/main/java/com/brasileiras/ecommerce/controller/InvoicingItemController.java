package com.brasileiras.ecommerce.controller;
import com.brasileiras.ecommerce.model.InvoicingItem;
import com.brasileiras.ecommerce.service.InvoicingItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoicing-item")
public class InvoicingItemController {
    private final InvoicingItemService invoicingItemService;

    public InvoicingItemController(InvoicingItemService invoicingItemService) {
        this.invoicingItemService = invoicingItemService;
    }

    @GetMapping
    public List<InvoicingItem> getAll() {
        return invoicingItemService.findAll();
    }

    @GetMapping("/{id}")
    public InvoicingItem getById(@PathVariable Long id) {
        return invoicingItemService.findById(id);
    }

    @PutMapping
    public void update(@PathVariable Long id, @RequestBody InvoicingItem invoicingItem) {
        invoicingItemService.update(id, invoicingItem);
    }

    @PostMapping
    public InvoicingItem save(@RequestBody InvoicingItem invoicingItem) {
        return invoicingItemService.save(invoicingItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        invoicingItemService.delete(id);
    }
}
