package com.example.mycoffee.entities;


import com.example.mycoffee.entities.roles.AccountRoles;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "number", unique = true)
    private String number;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private AccountRoles role;
}
