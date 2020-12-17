package com.example.myapplication.View;

import java.util.HashMap;

public interface INetWorkInterFace {
    public <T> void get (String url,CallBack<T>callBack);
    public <T> void post(String url,CallBack<T>callBack);
    public <T> void post(String url, HashMap<String,String>map, CallBack<T>callBack);

}
