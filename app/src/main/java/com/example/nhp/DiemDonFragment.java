package com.example.nhp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DiemDonFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diem_don, container, false);
        Button diemdon = view.findViewById(R.id.bttieptucddon);
        diemdon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiemDenFragment diemden = new DiemDenFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, diemden);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}