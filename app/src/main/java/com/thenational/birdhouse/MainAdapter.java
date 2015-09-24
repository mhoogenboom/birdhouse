package com.thenational.birdhouse;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.thenational.birdhouse.exponential.ExponentialFragment;
import com.thenational.birdhouse.fibonacci.FibonacciFragment;
import com.thenational.birdhouse.linear.LinearFragment;
import com.thenational.birdhouse.factorial.FactorialFragment;

import java.util.List;

import static java.util.Arrays.asList;

public class MainAdapter extends FragmentStatePagerAdapter {
    
    public enum Page {
        LINEAR, FIBONACCI, EXPONENTIAL, FACTORIAL;
    }
    
    private final List<Page> mPages;
    
    public MainAdapter(FragmentManager fragmentManager, Page... pages) {
        super(fragmentManager);
        mPages = asList(pages);
    }
    
    @Override
    public int getCount() {
        return mPages.size();
    }
    
    @Override
    public Fragment getItem(int position) {
        switch (mPages.get(position)) {
            case LINEAR:
                return LinearFragment.newInstance();
            case FIBONACCI:
                return FibonacciFragment.newInstance();
            case EXPONENTIAL:
                return ExponentialFragment.newInstance();
            case FACTORIAL:
                return FactorialFragment.newInstance();
            default:
                return null;
        }
    }
}
