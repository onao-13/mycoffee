package com.example.mycoffee.mapping.responses;

import com.example.mycoffee.entities.dataobject.OrderInfo;
import com.example.mycoffee.entities.dataobject.ProductInOrder;
import com.example.mycoffee.payment.PaymentType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderResponse {

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentType payment;

    @NotNull
    private OrderInfo info;

    @NotNull
    List<ProductInOrder> order = new ArrayList<>();
}
