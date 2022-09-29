package com.example.mycoffee.service;

import com.example.mycoffee.entities.Product;

public interface ProductService {
    void addProduct(Product product);
    Product getProductById(Integer id);
}
