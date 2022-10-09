package com.example.mycoffee.service;

import com.example.mycoffee.entities.Account;
import com.example.mycoffee.mapping.requests.AuthRequest;
import com.example.mycoffee.mapping.requests.RegistrationRequest;
import com.example.mycoffee.mapping.responses.AccountResponse;

import java.util.Optional;

public interface AccountService {
    void registration(RegistrationRequest newAccount);
    AccountResponse login(AuthRequest authRequest);
}
