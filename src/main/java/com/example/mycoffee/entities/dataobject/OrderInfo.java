package com.example.mycoffee.entities.dataobject;

import com.example.mycoffee.payment.PaymentType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class OrderInfo {

    @NotNull
    @Column(name = "buyer_name")
    private String buyerName;

    @NotNull
    @Column(name = "total_price")
    private Double totalPrice;

    @NotNull
    @Column(name = "order_date")
    private LocalDate orderDate;
}
