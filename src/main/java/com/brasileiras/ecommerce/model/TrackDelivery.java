package com.brasileiras.model;

import jakarta.persistence.*;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public List<DeliveryEvent> getEvents() {
        return events;
    }

    public void setEvents(List<DeliveryEvent> events) {
        this.events = events;
    }

    public int getDeliveryAttempts() {
        return deliveryAttempts;
    }

    public void setDeliveryAttempts(int deliveryAttempts) {
        this.deliveryAttempts = deliveryAttempts;
    }
}
