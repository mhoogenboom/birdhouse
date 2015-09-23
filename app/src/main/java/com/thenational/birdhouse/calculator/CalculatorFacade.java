package com.thenational.birdhouse.calculator;

import android.content.Context;
import android.support.v4.content.Loader;

import com.thenational.birdhouse.loader.CustomLoader;
import com.thenational.birdhouse.loader.Result;

import rx.Observable;
import rx.Subscriber;

public class CalculatorFacade {
    
    private final Calculator mCalculator;
    
    public CalculatorFacade(Calculator calculator) {
        mCalculator = calculator;
    }
    
    public Loader<Result<CharSequence>> calculateLinear(Context context, final int base) {
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

    public Loader<Result<CharSequence>> calculateFibonacci(Context context) {
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

    public Observable<Result<CharSequence>> calculateFactorial() {
        return Observable.create(new Observable.OnSubscribe<Result<CharSequence>>() {
            @Override
            public void call(Subscriber<? super Result<CharSequence>> subscriber) {
                try {
                    CharSequence data = mCalculator.factorial();
                    subscriber.onNext(new Result<>(data));
                    subscriber.onCompleted();
                } catch (CalculationException e) {
                    subscriber.onError(e);
                }
            }
        });         
    }
}
