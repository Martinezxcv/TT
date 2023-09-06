package com.example.shopSpring.data.addresses.service;

import com.example.shopSpring.data.addresses.model.Address;
import com.example.shopSpring.data.addresses.model.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAllAddresses();
    void addAddress(AddressDto address);
}
