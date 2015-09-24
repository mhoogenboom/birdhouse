package com.thenational.birdhouse.exponential;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thenational.birdhouse.BaseFragment;
import com.thenational.birdhouse.R;
import com.thenational.birdhouse.calculator.CalculationException;
import com.thenational.birdhouse.loader.Result;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ExponentialFragment extends BaseFragment {

    public static Fragment newInstance() {
        Bundle args = new Bundle();

        Fragment fragment = new ExponentialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView mSeriesView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exponential_fragment, container, false);

        mSeriesView = (TextView) view.findViewById(R.id.exponential_fragment_view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mSeriesView.setText(R.string.loading);

        mCalculatorFacade.calculateExponential(2)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<CharSequence>bindToLifecycle())
                .subscribe(new Subscriber<CharSequence>() {

                    @Override
                    public void onNext(CharSequence data) {
                        Log.d("---", "Calculated series for " + this);
                        mSeriesView.setText(data);
                    }

                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        CalculationException ce = (CalculationException) e;
                        mSeriesView.setText(ce.getCode() + " " + ce.getMessage());
                    }
                });
    }
}
