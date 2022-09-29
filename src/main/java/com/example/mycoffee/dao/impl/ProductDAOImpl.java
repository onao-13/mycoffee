package com.example.mycoffee.dao.impl;

import com.example.mycoffee.dao.ProductDAO;
import com.example.mycoffee.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addNewProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public Product getProductById(Integer id) {
        return entityManager.find(Product.class, id);
    }
}
