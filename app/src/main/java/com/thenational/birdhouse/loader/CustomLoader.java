package com.thenational.birdhouse.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public abstract class CustomLoader<T> extends AsyncTaskLoader<Result<T>> {
    
    public CustomLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
