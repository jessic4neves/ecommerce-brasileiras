package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Address;
import com.brasileiras.ecommerce.service.AddressService;
import org.springframework.ecommerce.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressServiceService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PutMapping
    public void update(@PathVariable Long id, @RequestBody Address address) {
        addressService.update(id, address);
    }

    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}
