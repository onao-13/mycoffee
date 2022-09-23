package com.example.mycoffee.dao.impl;

import com.example.mycoffee.dao.OrderDAO;
import com.example.mycoffee.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createOrder(Order coffees) {
        entityManager.persist(coffees);
    }
    @Override
    @Transactional
    public Order getOrder(Long orderId) {
        return entityManager.find(Order.class, orderId);
    }
}
