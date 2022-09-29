package com.example.mycoffee.service.impl;

import com.example.mycoffee.dao.ProductDAO;
import com.example.mycoffee.entities.Product;
import com.example.mycoffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public void addProduct(Product product) {
        productDAO.addNewProduct(product);
    }

    @Override
    public Product getProductById(Integer id) {
        return productDAO.getProductById(id);
    }
}
