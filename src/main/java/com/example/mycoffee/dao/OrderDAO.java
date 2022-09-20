package com.example.mycoffee.dao;

import com.example.mycoffee.entities.Order;

public interface OrderDAO {
    void createOrder(Order coffees);
    Order getOrder(Long orderId);
}
