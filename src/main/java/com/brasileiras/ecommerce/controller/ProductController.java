package com.brasileiras.controller;

import com.brasileiras.model.Product;
import com.brasileiras.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
