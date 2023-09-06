package com.example.shopSpring.data.carts.mapper;

import com.example.shopSpring.data.carts.model.Cart;
import com.example.shopSpring.data.carts.model.CartDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDto toDto(Cart source);
    List<CartDto> toDtoList(List<Cart> source);
    Cart fromDto(CartDto destination);
}

