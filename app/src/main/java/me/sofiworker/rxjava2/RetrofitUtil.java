package me.sofiworker.rxjava2;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/22 23:18
 * @description retrofit2工具类
 */
public class RetrofitUtil {

    private static Retrofit instance;

    public static Retrofit getRetrofit(){
        if (instance == null) {
            String baseUrl = "https://www.wanandroid.com/";
            instance = new Retrofit.Builder().baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return instance;
    }
}
