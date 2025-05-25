package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.Client;
import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Client findById(Long id);
    Client save(Client client);
    void update(Long accountReceiveId, Client client);
    void delete(Long id);
}
