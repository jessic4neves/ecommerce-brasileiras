package com.brasileiras.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Double total;

    @ManyToOne
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SaleItem> items;
}
