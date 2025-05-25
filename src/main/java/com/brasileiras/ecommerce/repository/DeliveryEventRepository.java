package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.DeliveryEvent;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DeliveryEventRepository extends JpaRepository<DeliveryEvent, Long> {
}
