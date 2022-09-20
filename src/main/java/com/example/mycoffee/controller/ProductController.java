package com.example.mycoffee.controller;

import com.example.mycoffee.dto.CoffeeDTO;
import com.example.mycoffee.entities.Coffee;
import com.example.mycoffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping("/new-coffee")
    ResponseEntity addNewCoffee(@RequestBody Coffee coffee) {
        coffeeService.addNewCoffee(coffee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/coffee/{id}")
    ResponseEntity getCoffeeById(@PathVariable("id") Long id) {
        CoffeeDTO coffee = coffeeService.getCoffee(id);
        return ResponseEntity.ok().body(coffee);
    }
}
