package com.thenational.birdhouse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.thenational.birdhouse.calculator.Calculator;
import com.thenational.birdhouse.calculator.CalculatorLoaders;

public class BaseFragment extends Fragment {
    
    protected CalculatorLoaders mCalculatorLoaders;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("---", "Create " + this);
        mCalculatorLoaders = new CalculatorLoaders(new Calculator());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("---", "Start " + this);
    }
    
}
