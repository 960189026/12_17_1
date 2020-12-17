package com.example.myapplication.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.paersenter.MainParsenter;

public abstract class BaseActivity<T> extends AppCompatActivity {
    public T presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayId());
        if (presenter == null) {
            presenter = getPressas();
        }
        initView();
        initData();
    }

    protected abstract MainParsenter initData();

    protected abstract void initView();

    protected abstract T getPressas();

    protected abstract int getLayId();
}
