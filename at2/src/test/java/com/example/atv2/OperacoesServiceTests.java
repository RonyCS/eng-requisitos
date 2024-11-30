package com.example.atv2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperacoesServiceTests {

    @Test
    void testFactorialGetter(){
        assertEquals(120, OperacoesService.getFactorial(5));
    }

    @Test
    void testNullFactorialGetter(){
        assertThrows(IllegalArgumentException.class, () -> OperacoesService.getFactorial(0));
    }

    @Test
    void testBigValueFactorialGetter(){
        assertThrows(IllegalArgumentException.class, () -> OperacoesService.getFactorial(21));
    }

    @Test
    void testMaxValueGetter(){
        assertEquals(10, OperacoesService.maxValue(new int[] {0, 2, 5, 7, 9, 10}));
    }

    @Test
    void testExceptionMaxValueGetter(){
        assertThrows(IllegalArgumentException.class, () -> OperacoesService.maxValue(new int[] {}));
    }

    @Test
    void testVowelsNumber(){
        assertEquals(3, OperacoesService.getVowelNumber("Hello, World!"));
    }

    @Test
    void testExceptionVowelsNumber(){
        assertThrows(IllegalArgumentException.class, () -> OperacoesService.getVowelNumber(""));
    }
}
