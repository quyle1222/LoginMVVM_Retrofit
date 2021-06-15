package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Ultis.MySharePreferences;
import com.example.myapplication.fragment.Fragment_Info;
import com.example.myapplication.fragment.Fragment_Login;

public class MainActivity extends AppCompatActivity {
    MySharePreferences mySharePreferences;
    String id = "";
    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mySharePreferences = new MySharePreferences(this);
        try {
            token = mySharePreferences.getToken();
            id = mySharePreferences.getId();
        } catch (Exception e) {

        }
        if (token.isEmpty() && id.isEmpty()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new Fragment_Login()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new Fragment_Info()).commit();
        }
    }
}