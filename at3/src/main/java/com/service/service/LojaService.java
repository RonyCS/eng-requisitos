package com.service.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LojaService {

    private List<Product> stockList;

    public LojaService(){
        this.stockList = Collections.emptyList();
    }

    public LojaService(List<Product> products){
        this.stockList = products;
    }

    public void insertProduct(Product newProduct){
        this.stockList.add(newProduct);
    }

    public Product getProduct(){
        return this.stockList.getLast();
    }

    public static double getTotalAmount(List<Product> products, int discount){

        if(products == null){
            throw new IllegalArgumentException("Function expects a valid products List");
        }

        if(discount < 0 || discount > 70){
            throw new IllegalArgumentException("The discount may not be less than 0% or more than 70%");
        }

        if(products.isEmpty()){
            return 0.0;
        }

        double sum = products.stream().mapToDouble(Product::getPrice).sum();

        return sum - sum/100 * discount;
    }

    public static List<Product> getProductsInStock(List<Product> productsList){

        if (productsList == null) {
            throw new IllegalArgumentException("The product list cannot be null");
        }

        if(productsList.isEmpty()){
            return productsList;
        }

        return productsList.stream().filter(product -> product.getStock() > 0).collect(Collectors.toList());
    }

    public static boolean couponValidation(String coupon){

        if(coupon.length() != 7){
            throw new IllegalArgumentException("Coupon does not have enough characters");
        }

        if(!coupon.startsWith("CUPOM-")){
            throw new IllegalArgumentException("Coupon does not match the expected pattern");
        }

        return true;
    }

    public static double[] orderPrices(List<Product> productList){

        if(productList == null){
            throw new IllegalArgumentException("Argument must be a list of products");
        }

        if(productList.isEmpty()){
            return new double[0];
        }

        return productList
                .stream()
                .sorted((product1, product2) -> Double.compare(product2.getPrice(), product1.getPrice()))
                .mapToDouble(Product::getPrice)
                .toArray();
    }

    public static String[] checkStock(List<Product> productsList, int limitMin){
        if(productsList == null || productsList.isEmpty()){
            throw new IllegalArgumentException("A products list is expected");
        }

        if(limitMin < 1){
            throw new IllegalArgumentException("The minimum limit must be more than 1");
        }

        return productsList.stream().filter(product ->  product.getStock() < limitMin).map(Product::getName).toArray(String[]::new);
    }
}
