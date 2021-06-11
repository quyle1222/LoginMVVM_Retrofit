package com.example.myapplication.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.repository.Repository;
import com.example.myapplication.userModel.UserInfo;

import org.jetbrains.annotations.NotNull;

public class UserViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<UserInfo> userInfoLiveData;

    public UserViewModel(@NotNull Application application) {
        super(application);
        repository = new Repository(application);
        this.userInfoLiveData = repository.getUserData();
    }

    public LiveData<UserInfo> getUserInfoLiveData() {
        return userInfoLiveData;
    }
}
