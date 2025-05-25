package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
