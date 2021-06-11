package com.example.myapplication.retrofit;

import com.example.myapplication.loginModel.LoginInfo;
import com.example.myapplication.loginModel.LoginRequest;
import com.example.myapplication.userModel.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {
    @POST("/api/v1/login")
    Call<LoginInfo> loginRequest(@Body LoginRequest loginRequest);

    @GET("/api/v1/user/info")
        Call<UserInfo> getUserInfo( @Query("userId") String id);
}
