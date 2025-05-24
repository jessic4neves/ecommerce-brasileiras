package com.brasileiras.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String cpf;
    private String email;
    private String phone;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> addresses;
}

