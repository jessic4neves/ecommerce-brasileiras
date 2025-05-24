package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
