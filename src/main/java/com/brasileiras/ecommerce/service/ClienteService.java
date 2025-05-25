package com.brasileiras.service;

import com.brasileiras.model.Client;
import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Client findById(Long id);
    Client save(Client client);
    void updateStock(Long clientId, int quantity);
    void delete(Long id);
}
