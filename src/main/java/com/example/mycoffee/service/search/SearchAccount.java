package com.example.mycoffee.service.search;

import com.example.mycoffee.entities.Account;
import com.example.mycoffee.mapping.requests.AuthRequest;
import com.example.mycoffee.mapping.responses.AccountResponse;

import java.util.Optional;

public interface SearchAccount {
    Optional<Account> searchAccountByNumber(String number);
    AccountResponse searchAccountByName(String name);
    AccountResponse getAccountByAccountRequest(AuthRequest authRequest);

    AccountResponse searchAccountById(Integer id);
}
