package com.brasileiras.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DeliveyEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventDeliveryStatus status;

}