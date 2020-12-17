package com.example.myapplication.moude;
//import android.renderscript.Type;

import com.example.myapplication.View.Apsrvice;
import com.example.myapplication.View.CallBack;
import com.example.myapplication.View.INetWorkInterFace;
import com.example.myapplication.View.UrlContract;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetorfitUtils implements INetWorkInterFace {
    public static RetorfitUtils retorfitUtils;
    private final Apsrvice apsrvice;


    public static INetWorkInterFace RetorfitUtils() {
        if (retorfitUtils == null) {
            synchronized (RetorfitUtils().getClass()) {
                if (retorfitUtils == null) {
                    retorfitUtils = new RetorfitUtils();
                }
            }
        }
        return retorfitUtils;
    }

    private RetorfitUtils() {
        OkHttpClient bu = new OkHttpClient.Builder().build();
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(UrlContract.SUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apsrvice = builder.create(Apsrvice.class);

    }

    @Override
    public <T> void get(String url, final CallBack<T> callBack) {
        apsrvice.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                        try {
                            String s = responseBody.toString();
                            Type[] types = callBack.getClass().getGenericInterfaces();
                 /*  Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            T resultt = new Gson().fromJson(string, t);
                            callBack.onSuccess(resultt);*/
                            Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            T result = new Gson().fromJson(s, t);
                            callBack.onSuess(result);
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public <T> void post(String url, final CallBack<T> callBack) {
        apsrvice.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.toString();

                            Type[] type = callBack.getClass().getGenericInterfaces();
                            Type[] ac = ((ParameterizedType) type[0]).getActualTypeArguments();
                            Type c = ac[0];
                            T asd = new Gson().fromJson(string, c);
                            callBack.onSuess(asd);
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, final CallBack<T> callBack) {
        apsrvice.post(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        String string = responseBody.toString();
                        Type[] ccc = callBack.getClass().getGenericInterfaces();
                        Type[] type = ((ParameterizedType) ccc[0]).getActualTypeArguments();
                        Type t = ccc[0];
                        T resultt = new Gson().fromJson(string, t);
                        callBack.onSuess(resultt);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
