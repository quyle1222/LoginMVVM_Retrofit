package com.example.myapplication.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.Ultis.MySharePreferences;
import com.example.myapplication.viewmodel.UserViewModel;


public class Fragment_Info extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    TextView txtFullName;
    TextView txtEmail;
    ImageView imgAvatar;
    UserViewModel userViewModel;
    MySharePreferences mySharePreferences;
    Button btnLogOut;
    RelativeLayout layout;


    public Fragment_Info() {

    }

    public static Fragment_Info newInstance(String param1, String param2) {
        Fragment_Info fragment = new Fragment_Info();
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
        View view = inflater.inflate(R.layout.fragment__info, container, false);
        initView(view);
        getDataUser(view);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySharePreferences.removeId();
                mySharePreferences.removeToken();
                AppCompatActivity activityCompat = (AppCompatActivity) view.getContext();
                activityCompat.getSupportFragmentManager().beginTransaction().replace(R.id.mainDetailsFragment, new Fragment_Login()).addToBackStack(null).commit();
                layout.setVisibility(View.GONE);
            }
        });
        return view;
    }

    private void initView(View view) {
        txtFullName = view.findViewById(R.id.txtFullName);
        txtEmail = view.findViewById(R.id.txtEmail);
        imgAvatar = view.findViewById(R.id.imgAvatar);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        mySharePreferences = new MySharePreferences(view.getContext());
        btnLogOut = view.findViewById(R.id.btnLogOut);
        layout = view.findViewById(R.id.layoutDetailsFragment);
    }

    private void getDataUser(View view) {
        userViewModel.getUserInfoLiveData().observe(getViewLifecycleOwner(), userInfo -> {
            if (userInfo != null && userInfo.getSuccess()) {
                txtFullName.setText(userInfo.getData().getUserFullName());
                txtEmail.setText(userInfo.getData().getUserMail());
                imgAvatar.setImageURI(Uri.parse("https://test.kendo-suppli.jp" + userInfo.getData().getUserAvatarPath()));
            } else {
                txtFullName.setText("null");
            }
        });
    }
}