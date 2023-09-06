package com.example.shopSpring.data.products.model;

import com.example.shopSpring.data.carts.model.Cart;
import com.example.shopSpring.data.entities.Product_Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    Integer id;
    List<Cart> carts;
    String name;
    Float price;
    int quantity;
    String description;
    List<Product_Order> productOrders;

}
