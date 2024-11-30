package com.example.atv2;

import java.math.BigInteger;

public class OperacoesService {

    public static long getFactorial(int n){
        if(n <= 0){
            throw new IllegalArgumentException("The selected number must be a positive value");
        }

        if(n >= 21){
            throw new IllegalArgumentException("The function can't process numbers bigger than 21");
        }

        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int maxValue(int[] list){
        if(list.length == 0 || list == null){
            throw new IllegalArgumentException("The expected value is a list of valid integers");
        }

        int max = list[0];

        for(int i = 1; i < list.length; i++){
            max = max < list[i]?  list[i]: max;
        }

        return max;
    }

    public static int getVowelNumber(String text) {
        if(text.isEmpty() || text == null){
            throw new IllegalArgumentException("The argument must contain a text");
        }

        int count = 0;
        for (char c : text.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

}
