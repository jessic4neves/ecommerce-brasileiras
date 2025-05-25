package com.brasileiras.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class AccountPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Invoicing invoicing;
    private BigDecimal value;
    private LocalDate expirationDate;
    private LocalDate paymentDay;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    // Getters e Setters
}