package com.example.mycoffee.service.impl;

import com.example.mycoffee.dao.OrderDAO;
import com.example.mycoffee.entities.Order;
import com.example.mycoffee.entities.OrderInfo;
import com.example.mycoffee.entities.Product;
import com.example.mycoffee.entities.ProductInOrder;
import com.example.mycoffee.service.OrderService;
import com.example.mycoffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductService productService;
    
    @Override
    public void buy(Order order) {
        Double totalPrice = 0.0;

        for(ProductInOrder products : order.getProductInOrder()) {
            Product product = productService.getProductById(products.getId());
            int count = products.getCount();

            while(count != 0) {
                totalPrice += product.getPrice();
                count--;
            }
        }

        order.setOrderInfo(OrderInfo.builder()
                        .buyerName(null)
                        .orderDate(LocalDate.now())
                        .totalPrice(totalPrice)
                .build()
        );


        orderDAO.createOrder(order);
    }

    @Override
    public Order getOrderInfo(Long orderId) {
        return null;
    }
}
