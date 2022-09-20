package com.example.mycoffee.service.impl;

import com.example.mycoffee.dao.CoffeeDAO;
import com.example.mycoffee.dto.CoffeeDTO;
import com.example.mycoffee.entities.Coffee;
import com.example.mycoffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    @Autowired
    private CoffeeDAO coffeeDAO;

    @Autowired
    private CoffeeDTO coffeeDTO;

    @Override
    public CoffeeDTO getCoffee(Long id) {
        return coffeeDTO.getCoffee(id);
    }

    @Override
    public void addNewCoffee(Coffee coffee) {
        coffeeDAO.addNewCoffee(coffee);
    }
}
