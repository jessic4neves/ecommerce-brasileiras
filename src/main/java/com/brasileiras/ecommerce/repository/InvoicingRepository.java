package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
