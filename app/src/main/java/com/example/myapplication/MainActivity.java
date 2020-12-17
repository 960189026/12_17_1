package com.example.myapplication;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.contract.MainContract;
import com.example.myapplication.paersenter.MainParsenter;
import java.util.ArrayList;
public class MainActivity extends BaseActivity<MainParsenter> implements MainContract.ImainView {
    private RecyclerView mRlv;
    private ArrayList<Bean.DataBean> list;
    private Datapter datapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected MainParsenter initData() {
        return new MainParsenter(this);
    }


    public void initView() {
        mRlv = findViewById(R.id.rlv);
        list = new ArrayList<>();
        datapter = new Datapter(list, this);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mRlv.setAdapter(datapter);
    }

    @Override
    protected MainParsenter getPressas() {
        return null;
    }


    @Override
    protected int getLayId() {
        return R.layout.activity_main;
    }

    public void getList(Bean bean){
        list.addAll(bean.getData());
        datapter.notifyDataSetChanged();
    }

    public void onFail(String msg){
        Toast.makeText(this, "msg", Toast.LENGTH_SHORT).show();
    }
}