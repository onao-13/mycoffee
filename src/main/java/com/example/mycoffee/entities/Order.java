package com.example.mycoffee.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "buyer_id")
    private Long buyerId;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private Map<Long, Integer> coffeeOrder;

    public Order() {
    }

    public Order(Long buyerId, Map<Long, Integer> coffeeOrder) {
        this.buyerId = buyerId;
//        this.coffeeOrder = coffeeOrder;
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
