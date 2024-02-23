package com.example.nhp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DiemDenFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diem_den, container, false);
        Button diemden = view.findViewById(R.id.bttieptucdden);
        diemden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThongtinNguoidiFragment nguoidi = new ThongtinNguoidiFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, nguoidi);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}