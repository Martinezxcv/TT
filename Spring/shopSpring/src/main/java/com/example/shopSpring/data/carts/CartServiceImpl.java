package com.example.shopSpring.data.carts;

import com.example.shopSpring.data.carts.mapper.CartMapper;
import com.example.shopSpring.data.carts.model.Cart;
import com.example.shopSpring.data.carts.model.CartDto;
import com.example.shopSpring.data.carts.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    @Override
    public List<CartDto> getAllCarts() {
        return cartMapper.toDtoList(cartRepository.findAll());
    }
    @Override
    public void addCart(CartDto cart) {
        cartRepository.save(cartMapper.fromDto(cart));
    }
}
