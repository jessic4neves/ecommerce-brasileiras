package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
