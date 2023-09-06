package com.example.shopSpring.data.addresses;

import com.example.shopSpring.data.addresses.mapper.AddressMapper;
import com.example.shopSpring.data.addresses.model.AddressDto;
import com.example.shopSpring.data.addresses.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
 class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    @Override
    public List<AddressDto> getAllAddresses() { return addressMapper.toDtoList(addressRepository.findAll());}
    @Override
    public void addAddress(AddressDto address) {addressRepository.save(addressMapper.fromDto(address));
    }
}
