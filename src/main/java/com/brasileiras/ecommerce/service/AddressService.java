package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.Address;
import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address findById(Long id);
    Address save(Address address);
    void update(Long accountReceiveId, Address address);
    void delete(Long id);
}
