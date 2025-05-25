package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Client;
import com.brasileiras.ecommerce.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PutMapping
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }

    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
}
