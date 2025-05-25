package com.brasileiras.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DeliveryTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Sale sale;
    private String trackingCode;
    @OneToMany(cascade = CascadeType.ALL)
    private List<DeliveryEvent> events;
    private int deliveryAttempts;
}
