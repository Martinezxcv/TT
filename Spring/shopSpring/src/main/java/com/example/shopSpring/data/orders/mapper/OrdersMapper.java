package com.example.shopSpring.data.orders.mapper;

import com.example.shopSpring.data.orders.model.Orders;
import com.example.shopSpring.data.orders.model.OrdersDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdersMapper {

    OrdersDto toDto(Orders source);
    List<OrdersDto> toDtoList(List<Orders> source);
    Orders fromDto(OrdersDto destination);
}
