package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
