package com.example.mycoffee.entities.dataobject;

import com.example.mycoffee.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "order")
@Entity
@Table(name = "product_in_order")
public class ProductInOrder {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    @Column(name = "product_id")
    private Integer productId;

    @NotNull
    private Integer count;

//    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
