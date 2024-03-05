package com.example.nhp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.zalopay.sdk.Environment;
import vn.zalopay.sdk.ZaloPaySDK;


public class ThanhtoanFragment extends Fragment {



    Button btnZalo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thanhtoan, container, false);
         btnZalo = view.findViewById(R.id.btnZalo);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

//        // ZaloPay SDK Init
//        ZaloPaySDK.init(553, Environment.SANDBOX);
//        btnZalo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
        return view;
    }
}