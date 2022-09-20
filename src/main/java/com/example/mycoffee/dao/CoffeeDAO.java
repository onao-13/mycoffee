package com.example.mycoffee.dao;

import com.example.mycoffee.entities.Coffee;
import org.springframework.stereotype.Repository;


public interface CoffeeDAO {
    Coffee getCoffeeById(Long id);
    void addNewCoffee(Coffee coffee);
}
