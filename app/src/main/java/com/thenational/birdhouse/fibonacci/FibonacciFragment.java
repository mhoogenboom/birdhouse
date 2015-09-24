package com.thenational.birdhouse.fibonacci;

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

public class FibonacciFragment extends BaseFragment {

    private static final int FIBONACCI_LOADER_ID = 1;

    public static Fragment newInstance() {
        Bundle args = new Bundle();

        Fragment fragment = new FibonacciFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView mSeriesView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fibonacci_fragment, container, false);

        mSeriesView = (TextView) view.findViewById(R.id.fibonacci_fragment_view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mSeriesView.setText(R.string.loading);

        Bundle args = new Bundle();

        getLoaderManager().initLoader(FIBONACCI_LOADER_ID, args, loaderCb);
    }

    private final LoaderManager.LoaderCallbacks<Result<CharSequence>> loaderCb = new LoaderManager.LoaderCallbacks<Result<CharSequence>>() {
        @Override
        public Loader<Result<CharSequence>> onCreateLoader(int id, final Bundle args) {
            switch (id) {
                case FIBONACCI_LOADER_ID:
                    return mCalculatorFacade.calculateFibonacci(getActivity());
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
