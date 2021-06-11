package com.example.myapplication.userModel;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("errorCode")
    private int errorCode;

    @SerializedName("message")
    private String message;

    private UserData data;

    public UserInfo(Boolean success, int errorCode, String message, UserData data) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
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

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
