package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
