package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Client;
import com.brasileiras.ecommerce.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Client> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return repository.save(client);
    }
}
