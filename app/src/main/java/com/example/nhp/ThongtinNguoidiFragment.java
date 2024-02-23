package com.example.nhp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ThongtinNguoidiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongtin_nguoidi, container, false);
        Button thongtin = view.findViewById(R.id.bttieptucthongtin);
        thongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThanhtoanFragment thanhtoanFragment = new ThanhtoanFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment,thanhtoanFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}