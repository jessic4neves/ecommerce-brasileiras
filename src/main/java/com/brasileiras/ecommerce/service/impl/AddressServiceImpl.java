package com.brasileiras.service.impl;

import com.brasileiras.model.Address;
import com.brasileiras.repository.AddressRepository;
import com.brasileiras.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public void updateStock(Long addressId, int quantity) {
        Address address = findById(addressId);
        address.setEstoque(address.getEstoque() + quantity);
        addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
