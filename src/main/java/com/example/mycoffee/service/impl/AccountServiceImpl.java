package com.example.mycoffee.service.impl;

import com.example.mycoffee.dao.AccountDAO;
import com.example.mycoffee.entities.Account;
import com.example.mycoffee.entities.SecurityAccount;
import com.example.mycoffee.entities.roles.AccountRoles;
import com.example.mycoffee.exception.AuthenticationException;
import com.example.mycoffee.mapping.requests.AuthRequest;
import com.example.mycoffee.mapping.requests.RegistrationRequest;
import com.example.mycoffee.mapping.responses.AccountResponse;
import com.example.mycoffee.service.AccountService;
import com.example.mycoffee.service.search.SearchAccount;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SearchAccount searchAccount;

    @Override
    public void registration(RegistrationRequest newAccount) {
        Account account = mappingToAccount(newAccount);
        account.setRole(AccountRoles.USER);
        String securityPassword = encoder.encode(account.getPassword());
        account.setPassword(securityPassword);
        accountDAO.registration(account);
        log.trace("create new account: " + account);
    }

    private Account mappingToAccount(@NotNull RegistrationRequest accountRequest) {
        return Account.builder()
                .name(accountRequest.getName())
                .password(accountRequest.getPassword())
                .number(accountRequest.getNumber())
                .build();
    }

    @Override
    public AccountResponse login(AuthRequest authRequest) {
        Account account = accountDAO.login(authRequest);
        if(account == null) {
            throw new AuthenticationException("Аккаунт не найден");
        }

        if (encoder.matches(authRequest.getPassword(), account.getPassword())) {
            log.trace("login account by id: " + account.getId());
            return AccountResponse.builder()
                    .name(account.getName())
                    .number(account.getNumber())
                    .build();
        } else {
            throw new AuthenticationException("Неверный пароль");
        }

//        Authentication authentication;
//        try {
//            authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            authRequest.getName(), authRequest.getPassword()
//                    )
//            );
//            log.info(authentication.getDetails().toString());
//        } catch (BadCredentialsException e) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "имя или пароль неверны");
//        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return searchAccount.searchAccountByNumber(username)
                .map(SecurityAccount::new)
                .orElseThrow(() -> new UsernameNotFoundException("Юзер не найден"));

    }
}
