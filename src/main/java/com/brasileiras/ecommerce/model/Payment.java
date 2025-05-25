package com.brasileiras.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Sale sale;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private BigDecimal value;
    private int parcels;
    private String paymentData; // Número do cartão, chave PIX, etc.

}