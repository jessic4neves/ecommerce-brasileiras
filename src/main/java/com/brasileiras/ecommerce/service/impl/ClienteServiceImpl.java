package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.Client;
import com.brasileiras.ecommerce.repository.ClientRepository;
import com.brasileiras.ecommerce.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void update(Long clientId, Client client) {
        Client existingClient = findById(clientId);
        existingClient.setName(client.getName());
        existingClient.setCpf(client.getCpf());
        existingClient.setEmail(client.getEmail());
        existingClient.setPhone(client.getPhone());
        existingClient.setAddresses(client.getAddresses());

        clientRepository.save(existingClient);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
