package com.example.mycoffee.dao.impl;

import com.example.mycoffee.dao.CoffeeDAO;
import com.example.mycoffee.entities.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class CoffeeDAOImpl implements CoffeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Coffee getCoffeeById(Long id) {
        return entityManager.find(Coffee.class, id);
    }

    @Override
    @Transactional
    public void addNewCoffee(Coffee coffee) {
        entityManager.persist(coffee);
    }
}
