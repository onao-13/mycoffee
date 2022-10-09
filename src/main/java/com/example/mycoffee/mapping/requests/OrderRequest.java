package com.example.mycoffee.mapping.requests;

import com.example.mycoffee.entities.dataobject.OrderInfo;
import com.example.mycoffee.entities.dataobject.ProductInOrder;
import com.example.mycoffee.payment.PaymentType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequest {

    @NotNull
    private Integer buyerId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentType payment;

    @NotNull
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductInOrder> order = new ArrayList<>();
}
