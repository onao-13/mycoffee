package com.example.mycoffee.order;

import com.example.mycoffee.coffee.Coffee;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "buyer_id")
    private Long buyerId;

    @Column(name = "price")
    private Double price;

    @Column(name = "coffee_order")
    private List<Coffee> coffeeOrder;

    public Order() {
    }

    public Order(Long buyerId, Double price, List<Coffee> coffeeOrder) {
        this.buyerId = buyerId;
        this.price = price;
        this.coffeeOrder = coffeeOrder;
    }

    public void addToOrder(Coffee coffee) {
        coffeeOrder.add(coffee);
        price += coffee.price();
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
