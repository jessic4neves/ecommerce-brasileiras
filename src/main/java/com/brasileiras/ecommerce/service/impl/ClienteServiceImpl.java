package com.brasileiras.service.impl;

import com.brasileiras.model.Client;
import com.brasileiras.repository.ClientRepository;
import com.brasileiras.service.ClientService;
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
    @Transactional
    public void updateStock(Long clientId, int quantity) {
        Client client = findById(clientId);
        client.setEstoque(client.getEstoque() + quantity);
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
