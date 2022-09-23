package com.example.mycoffee.controller;

import com.example.mycoffee.entities.Coffee;
import com.example.mycoffee.entities.Order;
import com.example.mycoffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buy")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity buy(@RequestBody Order order) {
        orderService.buy(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/details/{id}")
    public Order getOrder(@RequestParam("id") Long id) {
        return orderService.getOrder(id);
    }
}
