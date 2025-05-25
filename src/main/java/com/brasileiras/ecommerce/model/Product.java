package com.brasileiras.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String description;
    private String barcode;
    private BigDecimal purchaseValue;
    private BigDecimal saleValue;
    private int stock;
    @ManyToOne
    private Supplier supplier;
    @OneToMany(mappedBy = "product")
    private List<InvoiceItem> invoiceItems;
    @OneToMany(mappedBy = "product")
    private List<SaleItem> saleItems;

}
