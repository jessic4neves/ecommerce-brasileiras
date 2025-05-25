package com.brasileiras.ecommerce.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper modelMapper;

    public Mapper() {
        this.modelMapper = new ModelMapper();
    }

    public <D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public void map(Object source, Object destination) {
        modelMapper.map(source, destination);
    }
}