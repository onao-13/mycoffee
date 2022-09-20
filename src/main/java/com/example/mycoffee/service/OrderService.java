package com.example.mycoffee.service;

import com.example.mycoffee.entities.Coffee;
import com.example.mycoffee.entities.Order;

import java.util.List;

public interface OrderService {
    void buy(Order order);
    Order getOrder(Long orderId);
}
