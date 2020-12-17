package com.example.myapplication.moude;

import com.example.myapplication.View.CallBack;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.contract.MainContract;
import com.example.myapplication.paersenter.MainParsenter;

public class MainMoude {
    private MainContract.ImParsenter mainParsenter;

    public MainMoude(MainContract.ImParsenter mainParsenter) {

        this.mainParsenter = mainParsenter;
    }

    public<T> void getList(String url, CallBack<T> CallBack) {
            mainParsenter.getResultList("成功");
        RetorfitUtils.RetorfitUtils().get(url,CallBack);
    }
}
