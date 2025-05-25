package com.brasileiras.ecommerce.repository;

import com.brasileiras.ecommerce.model.TrackDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TrackDeliveryRepository extends JpaRepository<TrackDelivery, Long> {
}
