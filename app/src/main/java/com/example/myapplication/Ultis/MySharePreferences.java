package com.example.myapplication.Ultis;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreferences {
    Context mContext;
    private final String MY_SHARE_PREFERENCES = "MY_SHARE_PREFERENCES";

    public MySharePreferences(Context context) {
        this.mContext = context;
    }

    public void saveToken(String token) {
        SharedPreferences accountToken = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor mainToken = accountToken.edit().putString("token", token);
        mainToken.apply();
    }

    public String getToken() {
        SharedPreferences accountToken = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE);
        return accountToken.getString("token", "");
    }

    public void removeToken() {
        SharedPreferences accountToken = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor mainToken = accountToken.edit().clear();
        mainToken.apply();
    }

    public void saveId(String id) {
        SharedPreferences accountToken = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor mainID = accountToken.edit().putString("id", id);
        mainID.apply();
    }

    public String getId() {
        SharedPreferences accountToken = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE);
        return accountToken.getString("id", "");
    }

    public void removeId() {
        SharedPreferences accountToken = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor mainID = accountToken.edit().clear();
        mainID.apply();
    }
}
