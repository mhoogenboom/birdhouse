package com.thenational.birdhouse.factorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thenational.birdhouse.BaseFragment;
import com.thenational.birdhouse.R;
import com.thenational.birdhouse.loader.Result;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FactorialFragment extends BaseFragment {

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

        mCalculatorFacade.calculateFactorial()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<Result<CharSequence>>bindToLifecycle())
                .subscribe(new Subscriber<Result<CharSequence>>() {

                    @Override
                    public void onNext(Result<CharSequence> result) {
                        Log.d("---", "Data loaded for " + this);
                        if (result.isSuccess()) {
                            mSeriesView.setText(result.getData());
                        } else {
                            mSeriesView.setText(result.getErrorCode() + " " + result.getErrorMessage());
                        }
                    }

                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        mSeriesView.setText("");
                    }
                });
    }
}
