package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.Address;
import com.brasileiras.ecommerce.repository.AddressRepository;
import com.brasileiras.ecommerce.service.AddressService;
import org.springframework.stereotype.Service;

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
    public void update(Long addressId, Address updatedAddress) {
        Address existingAddress = findById(addressId);
        existingAddress.setAddress(updatedAddress.getAddress());
        existingAddress.setNumber(updatedAddress.getNumber());
        existingAddress.setComplement(updatedAddress.getComplement());
        existingAddress.setNeighborhood(updatedAddress.getNeighborhood());
        existingAddress.setCity(updatedAddress.getCity());
        existingAddress.setState(updatedAddress.getState());
        existingAddress.setZip(updatedAddress.getZip());
        existingAddress.setUser(updatedAddress.getUser());

        addressRepository.save(existingAddress);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
