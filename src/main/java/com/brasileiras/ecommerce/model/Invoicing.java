package com.brasileiras.ecommerce.model;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDate emissionDate) {
        this.emissionDate = emissionDate;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<InvoicingItem> getItems() {
        return items;
    }

    public void setItems(List<InvoicingItem> items) {
        this.items = items;
    }

    public AccountPay getAccountPay() {
        return accountPay;
    }

    public void setAccountPay(AccountPay accountPay) {
        this.accountPay = accountPay;
    }
}
