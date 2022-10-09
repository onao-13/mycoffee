package com.example.mycoffee.dao;

import com.example.mycoffee.entities.Account;
import com.example.mycoffee.mapping.requests.AuthRequest;

import java.util.Optional;

public interface AccountDAO {
    void registration(Account account);
    Account login(AuthRequest authRequest);
}
