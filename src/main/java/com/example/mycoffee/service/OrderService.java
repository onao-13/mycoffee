package com.example.mycoffee.service;

import com.example.mycoffee.entities.Order;
import com.example.mycoffee.mapping.requests.OrderRequest;
import com.example.mycoffee.mapping.responses.OrderResponse;
import com.example.mycoffee.mapping.responses.PaymentResponse;

public interface OrderService {
    PaymentResponse buy(OrderRequest request);
    OrderResponse getOrderById(Integer buyerId, Long orderId);
}
