package com.thenational.birdhouse.calculator;

import android.content.Context;
import android.support.v4.content.Loader;

import com.thenational.birdhouse.loader.CustomLoader;
import com.thenational.birdhouse.loader.Result;

public class CalculatorLoaders {
    
    private final Calculator mCalculator;
    
    public CalculatorLoaders(Calculator calculator) {
        mCalculator = calculator;
    }
    
    public Loader<Result<CharSequence>> linearLoader(Context context, final int base) {
        return new CustomLoader<CharSequence>(context) {
            @Override
            public Result<CharSequence> loadInBackground() {
                try {
                    CharSequence data = mCalculator.linear(base);
                    return new Result(data);
                } catch (CalculationException e) {
                    return new Result(e.getCode(), e.getMessage());
                }
            }
        };
    }

    public Loader<Result<CharSequence>> fibonacciLoader(Context context) {
        return new CustomLoader<CharSequence>(context) {
            @Override
            public Result<CharSequence> loadInBackground() {
                try {
                    CharSequence data = mCalculator.fibonacci();
                    return new Result(data);
                } catch (CalculationException e) {
                    return new Result(e.getCode(), e.getMessage());
                }
            }
        };
    }

    public Loader<Result<CharSequence>> factorialLoader(Context context) {
        return new CustomLoader<CharSequence>(context) {
            @Override
            public Result<CharSequence> loadInBackground() {
                try {
                    CharSequence data = mCalculator.factorial();
                    return new Result(data);
                } catch (CalculationException e) {
                    return new Result(e.getCode(), e.getMessage());
                }
            }
        };
    }
}
