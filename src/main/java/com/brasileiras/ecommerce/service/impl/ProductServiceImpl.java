package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.Product;
import com.brasileiras.ecommerce.repository.ProductRepository;
import com.brasileiras.ecommerce.service.ProductService;
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
    public void update(Long productId, Product product) {
        Product existingProduct = findById(productId);

        existingProduct.setCode(product.getCode());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBarcode(product.getBarcode());
        existingProduct.setPurchaseValue(product.getPurchaseValue());
        existingProduct.setSaleValue(product.getSaleValue());
        existingProduct.setStock(product.getStock());
        existingProduct.setSupplier(product.getSupplier());

        productRepository.save(existingProduct);
    }

    @Override
    @Transactional
    public void updateStock(Long productId, int quantity) {
        Product product = findById(productId);
        product.setStock(product.getStock() + quantity);
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
