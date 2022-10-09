package com.example.mycoffee.service.impl;

import com.example.mycoffee.dao.OrderDAO;
import com.example.mycoffee.entities.Order;
import com.example.mycoffee.entities.dataobject.OrderInfo;
import com.example.mycoffee.entities.Product;
import com.example.mycoffee.entities.dataobject.ProductInOrder;
import com.example.mycoffee.exception.OrderNotFoundException;
import com.example.mycoffee.mapping.requests.OrderRequest;
import com.example.mycoffee.mapping.responses.OrderResponse;
import com.example.mycoffee.mapping.responses.PaymentResponse;
import com.example.mycoffee.service.OrderService;
import com.example.mycoffee.service.ProductService;
import com.example.mycoffee.service.search.SearchAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductService productService;

    @Autowired
    private SearchAccount searchAccount;

//    @Autowired
//    private ProductOrderService productOrderService;

    @Override
    public PaymentResponse buy(OrderRequest request) {
        Double totalPrice = 0.0;

        for (ProductInOrder productInOrder : request.getOrder()) {
            Product product = productService.getProductById(productInOrder.getProductId());
            int count = productInOrder.getCount();

            while (count != 0) {
                totalPrice += product.getPrice();
                count--;
            }
        }

        String buyerName = searchAccount.searchAccountById(request.getBuyerId()).getName();

        Order order = Order.builder()
                .buyerId(request.getBuyerId())
                .payment(request.getPayment())
                .info(OrderInfo.builder()
                        .buyerName(buyerName)
                        .orderDate(LocalDate.now())
                        .totalPrice(totalPrice)
                        .build()
                )
                .order(new ArrayList<>())
                .build();
        request.getOrder().stream().forEach(product ->
                order.addToOrder(product)
        );
        orderDAO.createOrder(order);

        log.trace("create new order. Account id: " + request.getBuyerId());

//        order.getOrder().stream().filter(Objects::nonNull).forEach(product ->
//                productOrderService.addToOrder(
//                        ProductOrder.builder()
//                                .orderId(order.getId())
//                                .productId(product.getId())
//                                .productCount(product.getCount())
//                                .build()
//                )
//        );

        return PaymentResponse.builder().price(totalPrice).build();
    }

    @Override
    public OrderResponse getOrderById(Integer buyerId, Long orderId) {
        Order order = orderDAO.getOrderById(buyerId, orderId);

        if (order == null) throw new OrderNotFoundException("Заказ не найден");

        OrderResponse orderResponse = OrderResponse.builder()
                .payment(order.getPayment())
                .info(order.getInfo())
                .order(order.getOrder())
                .build();

        return orderResponse;
    }
}
