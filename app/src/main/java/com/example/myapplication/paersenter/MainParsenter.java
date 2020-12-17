package com.example.myapplication.paersenter;

import android.widget.BaseAdapter;

import com.example.myapplication.MainActivity;
import com.example.myapplication.View.CallBack;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.contract.MainContract;
import com.example.myapplication.moude.MainMoude;

public class MainParsenter extends BasePresenter implements MainContract.ImParsenter{

    private MainContract.ImainView imainView;
    private final MainMoude mainMoude;

    public MainParsenter(MainContract.ImainView imainView) {
        mainMoude = new MainMoude(this);
        this.imainView = imainView;
    }

    @Override
    public void getList() {
        mainMoude.getList("Girl/page/1/count/10",new CallBack<Bean>(){

            @Override
            public void onSuess(Bean bean) {
               imainView.getList(bean);
            }

            @Override
            public void onFail(String msg) {
            imainView.onFail(msg);
            }
        });


            }

    @Override
    public void getResultList(String result) {

    }
}
