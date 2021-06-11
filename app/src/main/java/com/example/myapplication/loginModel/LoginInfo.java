package com.example.myapplication.loginModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginInfo {
    @SerializedName("success")
    private boolean success;

    @SerializedName("errorCode")
    private int errorCode;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private LoginData data;

    public LoginInfo(boolean success, int errorCode, String message, LoginData data) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }
}
