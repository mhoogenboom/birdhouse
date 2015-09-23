package com.thenational.birdhouse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.thenational.birdhouse.calculator.Calculator;
import com.thenational.birdhouse.calculator.CalculatorFacade;
import com.trello.rxlifecycle.components.support.RxFragment;

public class BaseFragment extends RxFragment {
    
    protected CalculatorFacade mCalculatorFacade;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("---", "Create " + this);
        mCalculatorFacade = new CalculatorFacade(new Calculator());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("---", "Start " + this);
    }

    @Override
    public void onPause() {
        Log.d("---", "Pause " + this);
        super.onPause();        
    }

}
