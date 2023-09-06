package com.example.shopSpring.data.addresses.mapper;

import com.example.shopSpring.data.addresses.model.Address;
import com.example.shopSpring.data.addresses.model.AddressDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto toDto(Address source);
    List<AddressDto> toDtoList(List<Address> source);
    Address fromDto(AddressDto destination);
}
