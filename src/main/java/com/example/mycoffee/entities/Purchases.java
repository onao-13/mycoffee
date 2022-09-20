package com.example.mycoffee.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "buyer_id")
    private Long buyerId;

    @Column(name = "total_price")
    private Double totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Purchases purchases = (Purchases) o;
        return id != null && Objects.equals(id, purchases.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
