package com.example.calculator_service;

public class CalculatorService {

    public int sum(int a, int b){
        return a + b;
    }

    public int sub(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public double divide(double a, double b){

        if(b == 0.0){
            throw new ArithmeticException("Cannot divide by zero");
        }

        return a / b;
    }
}
