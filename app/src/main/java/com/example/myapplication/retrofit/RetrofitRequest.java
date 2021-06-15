package com.example.myapplication.retrofit;

import android.content.Context;

import com.example.myapplication.Ultis.MySharePreferences;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.myapplication.constant.AppConstant.BASE_URL;

public class RetrofitRequest {

    private static Retrofit retrofit;
    private static MySharePreferences mySharePreferences;

    public static Retrofit getRetrofitInstance(Context context) {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            mySharePreferences = new MySharePreferences(context);
            String token = mySharePreferences.getToken();
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        }).build();

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getRetrofitLogin(Context context) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
