package com.example.nhp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ChuyenDiFragment extends Fragment {
    String Ngay;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chuyen_di, container, false);
        ChuyenDiFragment chuyendi = new ChuyenDiFragment();
        Button chonchuyen = view.findViewById(R.id.btchonchuyen);
        Bundle bundle = getArguments();
        if(bundle!= null)
        {
            Ngay = bundle.getString("Ngay");
        }
        chonchuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundled = new Bundle();
                ChongheFragment chonghe = new  ChongheFragment();
                bundled.putString("Ngay", Ngay);
                chonghe.setArguments(bundled);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, chonghe);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}