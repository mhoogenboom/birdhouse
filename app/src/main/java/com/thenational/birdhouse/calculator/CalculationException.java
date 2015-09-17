package com.thenational.birdhouse.calculator;

public class CalculationException extends Exception {

    private final int mCode;
    
    public CalculationException(int code, String message) {
        super(message);
        mCode = code;
    }
    
    public int getCode() {
        return mCode;
    }
}
