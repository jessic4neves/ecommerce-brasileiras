package com.brasileiras.ecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DeliveryEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventDeliveryStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventDeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(EventDeliveryStatus status) {
        this.status = status;
    }
}
