package com.example.mycoffee.controller;

import com.example.mycoffee.exception.OrderNotFoundException;
import com.example.mycoffee.mapping.requests.OrderRequest;
import com.example.mycoffee.mapping.responses.OrderResponse;
import com.example.mycoffee.mapping.responses.PaymentResponse;
import com.example.mycoffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/buy")
    ResponseEntity buy(@RequestBody OrderRequest request) {
        try {
            PaymentResponse response = orderService.buy(request);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}/orders/")
    ResponseEntity getOrder(
            @PathVariable(name = "id") Integer buyerId,
            @RequestParam("order_id") Long orderId
    ) {
        try {
            OrderResponse response = orderService.getOrderById(buyerId, orderId);
            return ResponseEntity.ok().body(response);
        } catch (OrderNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
