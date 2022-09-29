package com.example.mycoffee.dto;


//import com.example.mycoffee.ordertype.Coffee;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Data
//@Component
//public class CoffeeDTO {
//    @Autowired
//    @JsonIgnore
//    private CoffeeDAO coffeeDAO;
//
//    private Long id;
//    private String name;
//    private Double price;
//
//    public CoffeeDTO getCoffee(Long id) {
//        CoffeeDTO coffeeDTO = new CoffeeDTO();
//        Coffee coffee = coffeeDAO.getCoffeeById(id);
//        coffeeDTO.setId(coffee.getId());
////        coffeeDTO.setName(coffee.getName());
////        coffeeDTO.setPrice(coffee.getPrice());
//        return coffeeDTO;
//    }
//}
