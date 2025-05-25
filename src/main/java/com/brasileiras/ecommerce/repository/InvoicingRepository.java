package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.Invoicing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicingRepository extends JpaRepository<Invoicing, Long> {
}
