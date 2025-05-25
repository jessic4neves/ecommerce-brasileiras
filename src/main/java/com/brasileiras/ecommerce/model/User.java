package com.brasileiras.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;
    @OneToMany(mappedBy = "user")
    private List<Sale> sales;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;
}
