package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.AccountPay;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountPayRepository extends JpaRepository<AccountPay, Long> {
}
