package com.example.mycoffee.dao.impl;

import com.example.mycoffee.dao.SearchAccountDAO;
import com.example.mycoffee.entities.Account;
import com.example.mycoffee.mapping.requests.AuthRequest;
import com.example.mycoffee.mapping.responses.AccountResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class SearchAccountDAOImpl implements SearchAccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<Account> searchAccountByNumber(String number) {
        Account account = (Account) entityManager
                .createQuery("SELECT a FROM Account a" +
                        "WHERE a.number = :number")
                .setParameter("number", number)
                .getSingleResult();
        return Optional.of(account);
    }

    @Override
    @Transactional
    public AccountResponse getAccountByAccountRequest(AuthRequest request) {
        String number = request.getNumber();

        return (AccountResponse) entityManager.createQuery("SELECT a FROM Account a " +
                        "WHERE a.number = :number")
                .setParameter("number", number)
                .getSingleResult();
    }

    @Override
    @Transactional
    public AccountResponse searchAccountByName(String name) {
        return (AccountResponse) entityManager.createQuery("SELECT a FROM Account a" +
                        "WHERE a.name = :name") // error: token a
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    @Transactional
    public AccountResponse searchAccountById(Long id) {
        Account account = entityManager.find(Account.class, id);
        return AccountResponse.builder().name(account.getName()).build();
    }
}
