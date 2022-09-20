package com.example.mycoffee.dao.impl;

import com.example.mycoffee.dao.PurchasesDAO;
import com.example.mycoffee.entities.Purchases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class PurchasesDAOImpl implements PurchasesDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addPurchases(Purchases purchases) {
        entityManager.persist(purchases);
    }

    @Override
    @Transactional
    public Purchases getPurchases(Long id) {
        return entityManager.find(Purchases.class, id);
    }
}
