//package com.example.shopSpring;
//
//import com.example.shopSpring.data.addresses.AddressRepository;
//import com.example.shopSpring.data.addresses.mapper.AddressMapper;
//import com.example.shopSpring.data.addresses.model.Address;
//import com.example.shopSpring.data.addresses.model.AddressDto;
//import com.example.shopSpring.data.addresses.service.AddressService;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@RequiredArgsConstructor
//public class MapperTest {
//    AddressService addressService;
//    AddressMapper addressMapper;
//
//    @Test
//    public void givenSourceToDestination_whenMaps_thenCorrect() {
//        Address simpleSource = addressService.getAllAddresses().get(0);
//
//        AddressDto destination = addressMapper.sourceToDestination(simpleSource);
//
//        assertEquals(simpleSource.getCity(), destination.getCity());
//    }
//}
