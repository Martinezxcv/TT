package com.example.shopSpring.data.orders;

import com.example.shopSpring.data.orders.mapper.OrdersMapper;
import com.example.shopSpring.data.orders.model.Orders;
import com.example.shopSpring.data.orders.model.OrdersDto;
import com.example.shopSpring.data.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrdersMapper ordersMapper;

    @Override
    public List<OrdersDto> getAllOrders() {
        return ordersMapper.toDtoList(orderRepository.findAll());
    }

    @Override
    public void addOrder(OrdersDto orders) {
        orderRepository.save(ordersMapper.fromDto(orders));
    }
}
