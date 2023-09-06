package com.example.shopSpring.data.orders;

import com.example.shopSpring.data.orders.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
