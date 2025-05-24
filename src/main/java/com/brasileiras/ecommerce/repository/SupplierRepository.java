package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Client, Long> {
}
