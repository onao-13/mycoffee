package com.example.mycoffee.dao;

import com.example.mycoffee.entities.Account;
import com.example.mycoffee.mapping.requests.AuthRequest;
import com.example.mycoffee.mapping.responses.AccountResponse;

import java.util.Optional;

public interface SearchAccountDAO {
    Optional<Account> searchAccountByNumber(String number);
    AccountResponse getAccountByAccountRequest(AuthRequest request);
    AccountResponse searchAccountByName(String name);

    AccountResponse searchAccountById(Long id);
}
