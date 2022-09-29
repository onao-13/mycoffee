package com.example.mycoffee.controller;

import com.example.mycoffee.entities.Product;
import com.example.mycoffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/new-product")
    ResponseEntity addNewCoffee(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-product/")
    ResponseEntity getProductById(@RequestParam("id") Integer id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok().body(product);
    }
}
