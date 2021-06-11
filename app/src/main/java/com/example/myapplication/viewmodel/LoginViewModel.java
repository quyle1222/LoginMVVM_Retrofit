package com.example.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.loginModel.LoginInfo;
import com.example.myapplication.loginModel.LoginRequest;
import com.example.myapplication.repository.Repository;

public class LoginViewModel extends AndroidViewModel {

    private Repository repository;
    private MutableLiveData<LoginInfo> loginInfoLiveData;
    private LoginRequest loginRequest;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<LoginInfo> getInfoLogin() {
        this.loginInfoLiveData = repository.getLoginData(loginRequest);
        return loginInfoLiveData;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }
}
