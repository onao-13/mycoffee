package com.example.mycoffee.dao.impl;

import com.example.mycoffee.dao.OrderDAO;
import com.example.mycoffee.entities.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderDAOImpl implements OrderDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public Order getOrder(Integer orderId) {
        return entityManager.find(Order.class, orderId);
    }
}
