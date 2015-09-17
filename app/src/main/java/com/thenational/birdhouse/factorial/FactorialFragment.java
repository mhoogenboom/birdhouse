package com.thenational.birdhouse.factorial;

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

public class FactorialFragment extends BaseFragment {

    private static final int FACTORIAL_LOADER_ID = 1;

    public static Fragment newInstance() {
        Bundle args = new Bundle();

        Fragment fragment = new FactorialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView mSeriesView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.factorial_fragment, container, false);

        mSeriesView = (TextView) view.findViewById(R.id.factorial_fragment_view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mSeriesView.setText(R.string.loading);

        Bundle args = new Bundle();

        getLoaderManager().initLoader(FACTORIAL_LOADER_ID, args, loaderCb);
    }

    private final LoaderManager.LoaderCallbacks<Result<CharSequence>> loaderCb = new LoaderManager.LoaderCallbacks<Result<CharSequence>>() {
        @Override
        public Loader<Result<CharSequence>> onCreateLoader(int id, final Bundle args) {
            switch (id) {
                case FACTORIAL_LOADER_ID:
                    return mCalculatorLoaders.factorialLoader(getActivity());
            }
            return null;
        }

        @Override
        public void onLoadFinished(Loader<Result<CharSequence>> loader, Result<CharSequence> result) {
            Log.d("---", "Data loaded for " + this);
            if (result.isSuccess()) {
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
