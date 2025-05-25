package com.brasileiras.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class InvoicingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Invoicing invoicing;
    @ManyToOne
    private Product product;
    private int quantity;
    private BigDecimal unitaryValue;
    private BigDecimal totalValue;

}