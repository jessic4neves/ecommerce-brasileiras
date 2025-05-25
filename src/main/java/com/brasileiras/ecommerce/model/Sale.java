package com.brasileiras.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private LocalDateTime date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Address deliveryAddress;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> items;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<Payment> payments;
    @OneToMany(mappedBy = "sale")
    private List<AccountReceivable> accountsReceivable;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    @OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
    private DeliveryTracking tracking;

}
