package com.example.myapplication.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Ultis.MySharePreferences;
import com.example.myapplication.loginModel.LoginInfo;
import com.example.myapplication.loginModel.LoginRequest;
import com.example.myapplication.retrofit.ApiRequest;
import com.example.myapplication.retrofit.RetrofitRequest;
import com.example.myapplication.userModel.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private ApiRequest apiResult;
    private ApiRequest apiRequest;

    private MySharePreferences mySharePreferences;

    public Repository(Context context) {
        apiResult = RetrofitRequest.getRetrofitInstance(context).create(ApiRequest.class);
        apiRequest = RetrofitRequest.getRetrofitLogin(context).create(ApiRequest.class);
        mySharePreferences = new MySharePreferences(context);
    }

    public MutableLiveData<LoginInfo> getLoginData(LoginRequest loginRequest) {
        final MutableLiveData<LoginInfo> data = new MutableLiveData<>();
        apiRequest.loginRequest(loginRequest).enqueue(new Callback<LoginInfo>() {
            @Override
            public void onResponse(Call<LoginInfo> call, Response<LoginInfo> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                    mySharePreferences.saveToken(response.body().getData().getToken());
                    mySharePreferences.saveId(response.body().getData().getUserId());
                }
            }

            @Override
            public void onFailure(Call<LoginInfo> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<UserInfo> getUserData() {
        final MutableLiveData<UserInfo> data = new MutableLiveData<>();
        String id = mySharePreferences.getId();
        apiResult.getUserInfo(id).enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
