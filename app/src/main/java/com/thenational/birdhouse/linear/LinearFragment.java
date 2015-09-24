package com.thenational.birdhouse.linear;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thenational.birdhouse.BaseFragment;
import com.thenational.birdhouse.R;
import com.thenational.birdhouse.loader.Result;

public class LinearFragment extends BaseFragment {

    private static final int LINEAR_LOADER_ID = 1;
    
    private static final String ARG_BASE = "base";
    
    public static Fragment newInstance() {
        Bundle args = new Bundle();
        
        Fragment fragment = new LinearFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    private TextView mSeriesView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.linear_fragment, container, false);
        
        mSeriesView = (TextView) view.findViewById(R.id.linear_fragment_view);
        
        return view;
    }
    
    @Override
    public void onStart() {
        super.onStart();
        
        mSeriesView.setText(R.string.loading);
        
        Bundle args = new Bundle();
        args.putInt(ARG_BASE, 3);
        
        getLoaderManager().initLoader(LINEAR_LOADER_ID, args, loaderCb);
    }
    
    private final LoaderManager.LoaderCallbacks<Result<CharSequence>> loaderCb = new LoaderManager.LoaderCallbacks<Result<CharSequence>>() {
        @Override
        public Loader<Result<CharSequence>> onCreateLoader(int id, final Bundle args) {
            switch (id) {
                case LINEAR_LOADER_ID: 
                    int base = args.getInt(ARG_BASE);
                    return mCalculatorFacade.calculateLinear(getActivity(), base);
            }
            return null;
        }

        @Override
        public void onLoadFinished(Loader<Result<CharSequence>> loader, Result<CharSequence> result) {
            if (result.isSuccess()) {
                Log.d("---", "Calculated series for " + this);
                mSeriesView.setText(result.getData());    
            } else {
                mSeriesView.setText(result.getErrorCode() + " " + result.getErrorMessage());
            }
        }

        @Override
        public void onLoaderReset(Loader<Result<CharSequence>> loader) {
            mSeriesView.setText("");
        }
    };
}
