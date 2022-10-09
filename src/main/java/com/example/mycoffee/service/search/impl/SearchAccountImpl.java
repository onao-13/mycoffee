package com.example.mycoffee.service.search.impl;

import com.example.mycoffee.dao.SearchAccountDAO;
import com.example.mycoffee.entities.Account;
import com.example.mycoffee.mapping.requests.AuthRequest;
import com.example.mycoffee.mapping.responses.AccountResponse;
import com.example.mycoffee.service.search.SearchAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchAccountImpl implements SearchAccount {
    @Autowired
    private SearchAccountDAO searchAccountDAO;

    @Override
    public Optional<Account> searchAccountByNumber(String number) {
        return searchAccountDAO.searchAccountByNumber(number);
    }

    @Override
    public AccountResponse searchAccountByName(String name) {
        return searchAccountDAO.searchAccountByName(name); //error
    }

    @Override
    public AccountResponse getAccountByAccountRequest(AuthRequest authRequest) {
        return searchAccountDAO.getAccountByAccountRequest(authRequest);
    }

    @Override
    public AccountResponse searchAccountById(Integer id) {
        return searchAccountDAO.searchAccountById((id.longValue()));
    }
}
