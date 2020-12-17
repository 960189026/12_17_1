package com.example.myapplication.View;

public interface CallBack<T> {
    public void onSuess(T t);
    public void  onFail(String msg);
}
