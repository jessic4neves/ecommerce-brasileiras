package com.brasileiras.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String cnpj;
    private String stateRegistration;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "supplier")
    private List<Invoice> invoices;
}
