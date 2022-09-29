package com.example.mycoffee.controller;

import com.example.mycoffee.entities.Order;
import com.example.mycoffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/buy")
    public ResponseEntity buy(@RequestBody Order order) {
        orderService.buy(order);
        System.out.println(order);
        return ResponseEntity.ok().build();
    }
}
