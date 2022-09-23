package com.example.mycoffee.service.impl;

import com.example.mycoffee.dao.CoffeeDAO;
import com.example.mycoffee.entities.Coffee;
import com.example.mycoffee.dao.OrderDAO;
import com.example.mycoffee.entities.Order;
import com.example.mycoffee.entities.Purchases;
import com.example.mycoffee.service.CoffeeService;
import com.example.mycoffee.service.OrderService;
import com.example.mycoffee.service.PurchasesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CoffeeDAO coffeeDAO;

    @Autowired
    private PurchasesService purchasesService;

    @Override
    public void buy(Order order) {
//        Map<Long, Integer> coffees = order.getCoffeeOrder();
//        Purchases purchases = new Purchases();
//        Double price = 0.0;
//
//        for (Map.Entry<Long, Integer> coffee : coffees.entrySet()) {
//            for (int i = 0; i <= coffee.getValue(); i++) {
//                Coffee getCoffee = coffeeDAO.getCoffeeById(coffee.getKey());
//                price += getCoffee.getPrice();
////                log.trace("Price: {}", price);
//                System.out.println(price);
//            }
//        }
//
//        purchases.setTotalPrice(price);
//        purchases.setBuyerId(order.getBuyerId());
//        purchasesService.addPurchases(purchases);
//        orderDAO.createOrder(order);
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderDAO.getOrder(orderId);
    }
}
