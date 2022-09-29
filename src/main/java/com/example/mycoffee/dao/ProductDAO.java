package com.example.mycoffee.dao;

import com.example.mycoffee.entities.Product;

public interface ProductDAO {
    void addNewProduct(Product product);

    Product getProductById(Integer id);
}
