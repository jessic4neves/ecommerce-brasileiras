package com.brasileiras.service;

import com.brasileiras.model.Address;
import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address findById(Long id);
    Address save(Address address);
    void updateStock(Long addressId, int quantity);
    void delete(Long id);
}
