package com.example.shopSpring.data.orders.controller;

import com.example.shopSpring.data.orders.model.OrdersDto;
import com.example.shopSpring.data.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public @ResponseBody Iterable<OrdersDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public String addOrder(@RequestBody OrdersDto order) {
        orderService.addOrder(order);
        return "Added";
    }
}
