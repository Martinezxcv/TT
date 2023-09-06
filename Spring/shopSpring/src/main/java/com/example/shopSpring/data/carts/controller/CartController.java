package com.example.shopSpring.data.carts.controller;

import com.example.shopSpring.data.carts.model.Cart;
import com.example.shopSpring.data.carts.model.CartDto;
import com.example.shopSpring.data.carts.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "cart")
 class CartController {

    private final CartService cartService;

    @GetMapping
    public @ResponseBody Iterable<CartDto> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PostMapping
    public String addCart(@RequestBody CartDto cart) {
        cartService.addCart(cart);
        return "Added";
    }
}
