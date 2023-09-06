package com.example.shopSpring.data.orders.service;

import com.example.shopSpring.data.orders.model.OrdersDto;

import java.util.List;

public interface OrderService {
     List<OrdersDto> getAllOrders();

     void addOrder(OrdersDto orders);
}
