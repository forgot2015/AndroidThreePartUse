package com.linzongfu.androidthreepartuse.network;

import com.blankj.utilcode.util.LogUtils;
import com.linzongfu.androidthreepartuse.network.api.AccountApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lin ZongFu on 2018/4/13
 * 网络请求, 返回retrofit请求的接口
 */
public class Network {
    private static final String TAG = "Network";

    /**
     * 获取OkHttpClient实例
     *
     * @return
     */
    private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.w(TAG, "retrofitBack = " + message);
            }
        });

        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BASIC;
        loggingInterceptor.setLevel(level);

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        return httpClientBuilder.build();
    }

    private static OkHttpClient okHttpClient = getOkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static Retrofit retrofit = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(UrlConfig.HOST_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
            .build();

    private static AccountApi accountApi;

    public static AccountApi getAccountApi() {
        if (accountApi == null) {
            accountApi = retrofit.create(AccountApi.class);
        }
        return accountApi;
    }
}
