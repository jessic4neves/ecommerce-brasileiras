package com.brasileiras.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String barcode;
    private Double purchasePrice;
    private Double salePrice;
    private Integer stock;
    
    @ManyToOne
    private Supplier supplier;
}
