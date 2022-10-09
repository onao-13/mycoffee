package com.example.mycoffee.dao.impl;

import com.example.mycoffee.dao.AccountDAO;
import com.example.mycoffee.entities.Account;
import com.example.mycoffee.mapping.requests.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void registration(Account account) {
        entityManager.persist(account);
    }

    @Override
    @Transactional
    public Account login(AuthRequest authRequest) {
        String number = authRequest.getNumber();
        return entityManager.createQuery("select a from Account a " +
                        "where a.number = :number", Account.class)
                .setParameter("number", number)
                .getSingleResult();
    }
}
