package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Product;
import com.brasileiras.ecommerce.service.ProductService;
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
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PutMapping
    public void update(@PathVariable Long id, @RequestBody Product product) {
        productService.update(id, product);
    }

    @PutMapping
    public void updateStock(@PathVariable Long id, @RequestBody Long quantity) {
        productService.update(id, quantity);
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
