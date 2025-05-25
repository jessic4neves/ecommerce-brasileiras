package com.brasileiras.ecommerce.model;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoicing getInvoicing() {
        return invoicing;
    }

    public void setInvoicing(Invoicing invoicing) {
        this.invoicing = invoicing;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(BigDecimal unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
