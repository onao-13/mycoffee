package com.example.mycoffee.entities;

import com.example.mycoffee.payment.PaymentType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "buyer_id")
    private Long buyerId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Embedded
    @Column(name = "order_info")
    private OrderInfo orderInfo;


    @Embedded
    @Column(name = "product_order")
    private List<ProductInOrder> productInOrder = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
