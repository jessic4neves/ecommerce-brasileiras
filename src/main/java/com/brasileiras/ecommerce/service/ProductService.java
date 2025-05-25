package com.brasileiras.service;

import com.brasileiras.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void updateStock(Long productId, int quantity);
    void delete(Long id);
}
