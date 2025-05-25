package com.brasileiras.service.impl;

import com.brasileiras.model.Product;
import com.brasileiras.repository.ProductRepository;
import com.brasileiras.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateStock(Long productId, int quantity) {
        Product product = findById(productId);
        product.setEstoque(product.getEstoque() + quantity);
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
