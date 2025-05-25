package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.InvoicingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicingItemRepository extends JpaRepository<InvoicingItem, Long> {
}
