package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
