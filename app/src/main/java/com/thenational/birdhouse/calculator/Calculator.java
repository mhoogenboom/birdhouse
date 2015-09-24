package com.thenational.birdhouse.calculator;

import android.util.Log;

public class Calculator {

    private static final int SERIES_SIZE = 10;
    
    public CharSequence linear(int base) throws CalculationException {
        Log.d("---", "Calculate linear series with base " + base);
        
        int sum = base;
        
        StringBuilder series = new StringBuilder();
        series.append(sum);
        for (int i = 1; i < SERIES_SIZE; i++) {
            sum += base;
            series.append(' ');
            series.append(sum);
        }
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        
        return series;
    }
    
    public CharSequence fibonacci() throws CalculationException {
        Log.d("---", "Calculate Fibonacci series");
        
        int n1 = 1;
        int n2 = 1;
        int sum;
        
        StringBuilder series = new StringBuilder();
        series.append(n1);
        
        for (int i = 1; i < SERIES_SIZE; i++) {
            sum = n1 + n2;
            series.append(' ');
            series.append(n2);
            n1 = n2;
            n2 = sum;
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        
        return series;
    }
    
    public CharSequence exponential(int base) throws CalculationException {
        Log.d("---", "Calculate exponential series with base " + base);
        
        int n = 1;

        StringBuilder series = new StringBuilder();
        series.append(n);

        for (int i = 1; i < SERIES_SIZE; i++) {
            n *= base;
            series.append(' ');
            series.append(n);
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        return series;
    }
    
    public CharSequence factorial() throws CalculationException {
        Log.d("---", "Calculate factorial series");
        
        int n = 1;
        
        StringBuilder series = new StringBuilder();
        series.append(n);
        
        for (int i = 1; i < SERIES_SIZE; i++) {
            n *= (i + 1);
            series.append(' ');
            series.append(n);
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        return series;
    }
}
