package com.example.mycoffee.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ProductInOrder {
    @Column(name = "id")
    private Integer id;

    @Column(name = "count")
    private Integer count;
}
