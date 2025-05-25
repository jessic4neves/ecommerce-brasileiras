package com.brasileiras.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.brasileiras.ecommerce.model.enums.AccountStatus;

@Entity
public class AccountReceive {
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(LocalDate paymentDay) {
        this.paymentDay = paymentDay;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
