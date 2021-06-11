package com.example.myapplication.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.Ultis.MySharePreferences;
import com.example.myapplication.viewmodel.LoginViewModel;
import com.example.myapplication.loginModel.LoginRequest;

public class Fragment_Login extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText edtEmail, edtPassword;
    Button btnLogin;
    LoginViewModel loginViewModel;
    LinearLayout layout;
    MySharePreferences mySharePreferences;
    private String mParam1;
    private String mParam2;

    public Fragment_Login() {
    }

    public static Fragment_Login newInstance(String param1, String param2) {
        Fragment_Login fragment = new Fragment_Login();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__login, container, false);
        initView(view);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                LoginRequest loginRequest = new LoginRequest(email, password);
                loginCheck(view, loginRequest);
            }
        });
        return view;
    }

    private void initView(View view) {
        edtEmail = view.findViewById(R.id.edtEmail);
        edtPassword = view.findViewById(R.id.edtPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
        layout = view.findViewById(R.id.layoutContainerLogin);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        mySharePreferences = new MySharePreferences(view.getContext());
    }

    private void loginCheck(View view, LoginRequest loginRequest) {
        loginViewModel.setLoginRequest(loginRequest);
        loginViewModel.getInfoLogin().observe(this, loginInfo -> {
            if (loginInfo != null && loginInfo.isSuccess()) {
                Toast.makeText(view.getContext(), "Login Success", Toast.LENGTH_SHORT).show();
                AppCompatActivity activityCompat = (AppCompatActivity) view.getContext();
                activityCompat.getSupportFragmentManager().beginTransaction().replace(R.id.layoutLoginFragment, new Fragment_Info()).addToBackStack(null).commit();
                layout.setVisibility(View.GONE);
            } else {
                Toast.makeText(view.getContext(), "Login Fail", Toast.LENGTH_SHORT).show();
                edtEmail.setText(null);
                edtPassword.setText(null);
            }
        });
    }
}

