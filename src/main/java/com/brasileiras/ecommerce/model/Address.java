package com.brasileiras.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zip;
    @ManyToOne
    private User user;

    // Getters e Setters
}