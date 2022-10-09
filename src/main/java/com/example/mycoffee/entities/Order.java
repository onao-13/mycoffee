package com.example.mycoffee.entities;

import com.example.mycoffee.entities.dataobject.OrderInfo;
import com.example.mycoffee.entities.dataobject.ProductInOrder;
import com.example.mycoffee.payment.PaymentType;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = "order")
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "buyer_id")
    private Integer buyerId;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType payment;

    @NotNull
    @Embedded
    @Column(name = "order_info")
    private OrderInfo info;

    @NotNull
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductInOrder> order = new ArrayList<>();

    public void addToOrder(ProductInOrder product) {
        order.add(product);
        product.setOrder(this);
    }

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
