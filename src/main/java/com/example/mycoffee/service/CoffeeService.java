package com.example.mycoffee.service;

import com.example.mycoffee.dto.CoffeeDTO;
import com.example.mycoffee.entities.Coffee;

public interface CoffeeService {
    CoffeeDTO getCoffee(Long id);
    void addNewCoffee(Coffee coffee);
}
