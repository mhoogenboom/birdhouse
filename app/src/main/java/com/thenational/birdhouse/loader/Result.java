package com.thenational.birdhouse.loader;

public class Result<T> {
    
    private final T mData;
    
    private final int mErrorCode;
    private final String mErrorMessage;
    
    public Result(T data) {
        mData = data;
        
        mErrorCode = 0;
        mErrorMessage = null;
    }
    
    public Result(int errorCode, String errorMessage) {
        mData = null;
        
        mErrorCode = errorCode;
        mErrorMessage = errorMessage;
    }
    
    public boolean isSuccess() {
        return (mData != null) && (mErrorCode == 0) && (mErrorMessage == null);
    }
    
    public T getData() {
        return mData;
    }
            
    public int getErrorCode() {
        return mErrorCode;
    }
    
    public String getErrorMessage() {
        return mErrorMessage;
    }
}
