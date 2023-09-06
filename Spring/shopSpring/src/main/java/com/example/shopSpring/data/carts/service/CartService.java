package com.example.shopSpring.data.carts.service;

import com.example.shopSpring.data.carts.model.CartDto;

import java.util.List;

public interface CartService {

     List<CartDto> getAllCarts();
     void addCart(CartDto cart);
}
