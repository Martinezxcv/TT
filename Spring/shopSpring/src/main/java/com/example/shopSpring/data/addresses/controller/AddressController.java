package com.example.shopSpring.data.addresses.controller;

import com.example.shopSpring.data.addresses.model.Address;
import com.example.shopSpring.data.addresses.model.AddressDto;
import com.example.shopSpring.data.addresses.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "address")
class AddressController {

    private final AddressService addressService;

    @GetMapping
    public @ResponseBody Iterable<AddressDto> getAllAdresses() {
        return addressService.getAllAddresses();
    }

    @PostMapping
    public String addAddress(@RequestBody AddressDto address) {
        addressService.addAddress(address);
        return "Added";
    }
}
