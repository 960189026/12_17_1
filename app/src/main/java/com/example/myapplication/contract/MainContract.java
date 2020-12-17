package com.example.myapplication.contract;
import com.example.myapplication.View.CallBack;
import com.example.myapplication.bean.Bean;
public class MainContract {
    public interface IMainModel{
        <T> void getList(String url, CallBack<T> callBack);
    }
    public interface ImParsenter{
        void getList();
        void getResultList(String result);
    }
    public interface ImainView{
        void getList(Bean bean);
        void onFail(String msg);
    }
}
