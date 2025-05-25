package com.brasileiras.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Invoicing {
    @Id
    private String number;
    private LocalDate emissionDate;
    private LocalDate entryDate;
    @ManyToOne
    private Supplier supplier;
    @OneToMany(mappedBy = "invoicing", cascade = CascadeType.ALL)
    private List<InvoicingItem> items;
    @OneToOne(mappedBy = "invoicing", cascade = CascadeType.ALL)
    private AccountPay accountPay;

    // Getters e Setters
}