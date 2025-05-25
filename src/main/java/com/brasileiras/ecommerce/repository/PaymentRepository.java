package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
