package com.example.nhp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class XacnhanveFragment extends Fragment {
    TextView tuyen, nhaxe, giodi, ngaydi, maghe, tamtinh, soluong, tenkhach, sdt;
    Button datve;
    String Ngay;
    ArrayList<Integer> danhsachmaghe;
    int idtemp = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xacnhanve, container, false);
        tuyen = view.findViewById(R.id.tv_tuyen);
        nhaxe = view.findViewById(R.id.tv_ten_nha_xe);
        giodi = view.findViewById(R.id.tv_gio_di);
        ngaydi = view.findViewById(R.id.tv_ngay_di);
        maghe = view.findViewById(R.id.tv_ma_ghe);// lay
        tamtinh = view.findViewById(R.id.tv_tam_tinh);// lay
        tenkhach = view.findViewById(R.id.tv_ten_hanh_khach);// lay
        soluong = view.findViewById(R.id.tv_so_luong);
        sdt = view.findViewById(R.id.tv_sdt);// lay
        Button datve = view.findViewById(R.id.bt_xac_nhan_ve);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Ngay = bundle.getString("Ngay");
            danhsachmaghe = bundle.getIntegerArrayList("danhsachghe");
            maghe.setText(String.valueOf(danhsachmaghe));
            String tenNguoiDi = bundle.getString("tennguoidi");
            String soDienThoai = bundle.getString("sdt");
            int maghe1 = bundle.getInt("maghe");
            int tamtinh1 = bundle.getInt("tamtinh");
            // Hiển thị dữ liệu trong Fragment mới
            tenkhach.setText(tenNguoiDi);
            sdt.setText(soDienThoai);
            soluong.setText(String.valueOf(maghe1));
            tamtinh.setText(String.valueOf(tamtinh1));
            ngaydi.setText(Ngay);
        }

        datve = view.findViewById(R.id.bt_xac_nhan_ve);
        datve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPushdata();
                ThanhtoanFragment chonghe = new ThanhtoanFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, chonghe);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return view;
    }
    private void onClickPushdata() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_ve");//key
        Vexe ve = new Vexe();
        ve.tuyen = tuyen.getText().toString().trim();
        ve.nhaxe = nhaxe.getText().toString().trim();
        ve.gio = giodi.getText().toString().trim();
        ve.ngaydi = ngaydi.getText().toString().trim();
        ve.maghe = maghe.getText().toString().trim();
        ve.sodienthoai = sdt.getText().toString().trim();
        ve.tenkhachhang = tenkhach.getText().toString().trim();
        String tamtinhText = tamtinh.getText().toString().trim();
        int tamtinhValues = Integer.parseInt(tamtinhText);
        ve.tamtinh = tamtinhValues;
        String soluongText = soluong.getText().toString().trim();
        int soluongValues = Integer.parseInt(soluongText);
        ve.soluong = soluongValues;
        ve.id = idtemp;
        idtemp++;
        String path = String.valueOf(ve.getId());
        myRef.child(path).setValue((ve), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @androidx.annotation.NonNull DatabaseReference ref) {
                Toast.makeText(getContext(), "Xác nhận thành công", Toast.LENGTH_SHORT).show();
            }
        });//values

    }
}