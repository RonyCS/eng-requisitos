package com.service.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

public class LojaServiceTest {

    private List<Product> validProductsList;

    @BeforeEach
    void setup(){
        validProductsList = Arrays.asList(
                new Product("Coffee", 3.50, 5),
                new Product("Milk", 6.50, 10),
                new Product("Chocolate Cookies", 10.80, 15),
                new Product("Pasta", 8.00, 0),
                new Product("Meat", 26.99, 10),
                new Product("Water bottle", 0.00, 100)
        );
    }

    @Nested
    class GetTotalAmountTests {
        @Test
        void shouldReturnDoubleWhenValidProductsList() {
            assertEquals(55.79, LojaService.getTotalAmount(validProductsList, 0));
        }

        @Test
        void shouldReturnSmallerDoubleWhenValidProductsListAndDiscount() {
            assertEquals(50.211, LojaService.getTotalAmount(validProductsList, 10));
        }

        @Test
        void shouldThrowExceptionWhenDiscountIsNegative() {
            assertThrows(IllegalArgumentException.class, () -> LojaService.getTotalAmount(validProductsList, -3));
        }

        @Test
        void shouldThrowExceptionWhenProductsListIsNull() {
            assertThrows(IllegalArgumentException.class, () -> LojaService.getTotalAmount(null, 60));
        }

        @Test
        void shouldReturnZeroWhenProductsListIsEmpty() {
            assertEquals(0.0, LojaService.getTotalAmount(Collections.emptyList(), 0));
        }

    }

    @Nested
    class GetProductsInStockTests {
        @Test
        void shouldReturnListWithProductsWhenValidProductsList(){
            List<Product> productList = Arrays.asList(
                    new Product("Coffee", 3.50, 5),
                    new Product("Milk", 6.50, 10),
                    new Product("Chocolate Cookies", 10.80, 15),
                    new Product("Meat", 26.99, 10),
                    new Product("Water bottle", 0.00, 100)
            );
            assertIterableEquals(productList, LojaService.getProductsInStock(validProductsList));
        }

        @Test
        void shouldThrowExceptionWhenInvalidProductsList() {
            assertThrows(IllegalArgumentException.class, () -> LojaService.getProductsInStock(null));
        }

        @Test
        void shouldReturnEmptyProductsListWhenEmptyList() {
            List<Product> productsList = Collections.emptyList();
            assertEquals(productsList, LojaService.getProductsInStock(Collections.emptyList()));
        }

    }

    @Nested
    class CouponValidationTests {
        @Test
        void shouldReturnTrueWhenCouponIsValid() {
            assertTrue(LojaService.couponValidation("CUPOM-1"));
        }

        @Test
        void shouldThrowExceptionWhenCouponIsInvalid() {
            assertThrows(IllegalArgumentException.class, () -> LojaService.couponValidation("invalido"));
        }

    }

    @Nested
    class OrderPricesTests {
        @Test
        void shouldReturnArrayOfDoubleWhenValidProductsList() {
            double[] pricesList = {26.99, 10.80, 8.00, 6.50, 3.50, 0.00};
            assertArrayEquals(pricesList, LojaService.orderPrices(validProductsList));
        }

        @Test
        void shouldThrowExceptionWhenNullArgument() {
            assertThrows(IllegalArgumentException.class, () -> LojaService.orderPrices(null));
        }

        @Test
        void shouldReturnEmptyDoubleArrayWhenEmptyList() {
            double[] emptyArray = {};
            assertArrayEquals(emptyArray, LojaService.orderPrices(Collections.emptyList()));
        }

    }

    @Nested
    class CheckStockTests {
        @Test
        void shouldReturnStringArrayWhenValidList() {
            String[] productsNames = {"Coffee", "Milk", "Pasta", "Meat"};
            assertArrayEquals(productsNames, LojaService.checkStock(validProductsList, 12));
        }

        @Test
        void shouldReturnSmallerStringArrayWhenMinorMinLimit() {
            String[] productsNames = {"Coffee", "Pasta"};
            assertArrayEquals(productsNames, LojaService.checkStock(validProductsList, 10));
        }

        @Test
        void shouldThrowExceptionWhenNullProductsList() {
            assertThrows(IllegalArgumentException.class, () -> LojaService.checkStock(null, 10));
        }

        @Test
        void shouldThrowExceptionWhenEmptyProductsList() {
            assertThrows(IllegalArgumentException.class, () -> LojaService.checkStock(Collections.emptyList(), 10));
        }

        @Test
        void shouldThrowExceptionWhenInvalidMinimumLimit() {
            assertThrows(IllegalArgumentException.class, () -> LojaService.checkStock(validProductsList, 0));
        }
    }
}
