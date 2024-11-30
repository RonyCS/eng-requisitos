package com.service.service;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private int quantityInStock;

    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.quantityInStock = stock;
    }

    public void changePrice(double newPrice){
        this.price = newPrice;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public int getStock(){
        return this.quantityInStock;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                quantityInStock == product.quantityInStock &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, price, quantityInStock);
    }
}
