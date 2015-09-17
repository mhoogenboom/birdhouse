package com.thenational.birdhouse;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main_activity);
        
        PagerAdapter adapter = new MainAdapter(getSupportFragmentManager(), 
                MainAdapter.Page.LINEAR,
                MainAdapter.Page.FIBONACCI, 
                MainAdapter.Page.FACTORIAL);
        
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);
    }
}
