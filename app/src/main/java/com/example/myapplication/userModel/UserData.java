package com.example.myapplication.userModel;

public class UserData {
    private String userFullName;
    private String userMail;
    private String userAvatarPath;

    public UserData(String userFullName, String userMail, String userAvatarPath) {
        this.userFullName = userFullName;
        this.userMail = userMail;
        this.userAvatarPath = userAvatarPath;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserAvatarPath() {
        return userAvatarPath;
    }

    public void setUserAvatarPath(String userAvatarPath) {
        this.userAvatarPath = userAvatarPath;
    }
}
