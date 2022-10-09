package com.example.mycoffee.dao.impl;

import com.example.mycoffee.dao.OrderDAO;
import com.example.mycoffee.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    @Transactional
    public Order getOrderById(Integer buyerId, Long orderId) {
        Order order = entityManager.createQuery("select o from Order o " +
                        "where o.buyerId = :buyerId and o.id = :orderId", Order.class)
                .setParameter("buyerId", buyerId)
                .setParameter("orderId", orderId)
                .getSingleResult();

        return order;
    }
}
