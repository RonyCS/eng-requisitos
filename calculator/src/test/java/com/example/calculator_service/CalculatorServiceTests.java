package com.example.calculator_service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorServiceTests {

    private final CalculatorService calculatorService = new CalculatorService();


    @Test
    void testSum(){
        assertEquals(5, calculatorService.sum(2, 3));
    }

    @Test
    void testSub(){
        assertEquals(2, calculatorService.sub(5, 3));
    }

    @Test
    void testMultiply(){
        assertEquals(12, calculatorService.multiply(4, 3));
    }

    @Test
    void testDivision(){
        assertEquals(5.0, calculatorService.divide(10, 2));
    }

    @Test
    void testFractionDivision(){
        assertEquals(20, calculatorService.divide(10, 0.5));
    }

    @Test
    void testDivisionByZero(){
        assertThrows(ArithmeticException.class, () -> calculatorService.divide(10, 0));
    }
}
