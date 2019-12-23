package me.sofiworker.rxjava2.util;

import java.util.concurrent.TimeUnit;

import me.sofiworker.rxjava2.Api;
import okhttp3.OkHttpClient;
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

    private static Api instance;
    /**
     * 超时时间
     */
    private static final int TIME_OUT = 10;

    public static Api getApi(){
        if (instance == null) {
            String baseUrl = "https://www.wanandroid.com/";
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS);
            instance = new Retrofit.Builder().baseUrl(baseUrl)
                    .client(builder.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build().create(Api.class);
        }
        return instance;
    }


}
