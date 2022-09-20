package com.example.mycoffee.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    public Coffee(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Coffee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Coffee coffee = (Coffee) o;
        return id != null && Objects.equals(id, coffee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
