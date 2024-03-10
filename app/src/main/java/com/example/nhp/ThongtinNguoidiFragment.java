package com.example.nhp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ThongtinNguoidiFragment extends Fragment {

    int  tamtinh, maghe;
    String Ngay;
    ArrayList<Integer> selectedSeatIds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongtin_nguoidi, container, false);
        Button thongtin = view.findViewById(R.id.bttieptucthongtin);
        EditText tennguoidi = view.findViewById(R.id.edtennguoidi);
        EditText sdt = view.findViewById(R.id.edsdt);

        Bundle bundle = getArguments();
        if (bundle != null) {
            selectedSeatIds = bundle.getIntegerArrayList("selectedSeatIds");
            if (selectedSeatIds != null) {
                for (int seatId : selectedSeatIds);
            }
            Ngay = bundle.getString("Ngay");
            maghe = bundle.getInt("soLuong");
            tamtinh = bundle.getInt("soTien");
        }

        thongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenNguoidi =  tennguoidi.getText().toString().trim();
                String SDT =  sdt.getText().toString().trim();
                ArrayList<Integer> danhsanhghe = selectedSeatIds;
                Bundle bundle  = new Bundle();
                bundle.putString("Ngay", Ngay);
                bundle.putString("tennguoidi",tenNguoidi);
                bundle.putIntegerArrayList("danhsachghe", danhsanhghe);
                bundle.putString("sdt", SDT);
                bundle.putInt("maghe", maghe);
                bundle.putInt("tamtinh", tamtinh);
                XacnhanveFragment xacnhanveFragment = new XacnhanveFragment();
                xacnhanveFragment.setArguments(bundle);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment,xacnhanveFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}
