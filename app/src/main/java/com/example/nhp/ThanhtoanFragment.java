package com.example.nhp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ThanhtoanFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thanhtoan, container, false);
        Button thanhtoan = view.findViewById(R.id.thanhtoan);
        thanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoantatFragment hoantatFragment = new HoantatFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment,hoantatFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}