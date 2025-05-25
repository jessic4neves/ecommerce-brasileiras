package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
