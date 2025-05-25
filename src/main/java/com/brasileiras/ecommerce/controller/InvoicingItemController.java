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
        return invoicingItemService.getAll();
    }

    @GetMapping("/{id}")
    public InvoicingItem getById(@PathVariable Long id) {
        return invoicingItemService.getById(id);
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
