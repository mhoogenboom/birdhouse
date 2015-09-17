package com.thenational.birdhouse.calculator;

public class Calculator {

    public CharSequence linear(int base) throws CalculationException {
        int sum = base;
        
        StringBuilder series = new StringBuilder();
        series.append(sum);
        for (int i = 1; i < 10; i++) {
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
        int n1 = 1;
        int n2 = 1;
        int sum;
        
        StringBuilder series = new StringBuilder();
        series.append(n1);
        
        for (int i = 1; i < 10; i++) {
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
    
    public CharSequence factorial() throws CalculationException {
        int n = 1;
        
        StringBuilder series = new StringBuilder();
        series.append(n);
        
        for (int i = 1; i < 10; i++) {
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
