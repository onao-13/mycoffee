package com.example.mycoffee.coffee;

public abstract class Coffee {
    private String name;
    private Double price;
    private Integer count;

    public abstract Double price();
    public abstract String getName();
    public abstract void setCount(Integer count);
    public abstract Integer getCount();
}
