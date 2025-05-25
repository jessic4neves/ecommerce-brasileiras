package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.AccountReceive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountReceivableRepository extends JpaRepository<AccountReceive, Long> {
}
