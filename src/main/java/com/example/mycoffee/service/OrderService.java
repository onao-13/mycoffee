package com.example.mycoffee.service;

import com.example.mycoffee.entities.Order;

public interface OrderService {
    void buy(Order order);
    Order getOrderInfo(Long orderId);
}
