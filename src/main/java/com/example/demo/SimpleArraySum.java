package com.example.demo;

import java.util.Arrays;

public class SimpleArraySum {
    public static void main(String[] args){
        int numbers[] ={1,2,3,4};
         System.out.print(Arrays.stream(numbers).sum());

        System.out.print(truncateNumber(1213321441.444f));
    }

    static  String truncateNumber(float floatNumber){
    long million = 1000000L;
    long billion = 1000000000L;
    long trillion = 1000000000000L;
    long number = Math.round(floatNumber);
    if ((number >= million) && (number < billion)) {
        float fraction = calculateFraction(number, million);
        return Float.toString(fraction) + "M";
    } else if ((number >= billion) && (number < trillion)) {
        float fraction = calculateFraction(number, billion);
        return Float.toString(fraction) + "B";
    }
    return Long.toString(number);
}

    public static float calculateFraction(long number, long divisor) {
        long truncate = (number * 10L + (divisor / 2L)) / divisor;
        float fraction = (float) truncate * 0.10F;
        return fraction;
    }
}
