package com.example.nhp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TimkiemFragment extends Fragment {


    TextView ntext, ntext1, ntext2;
    ViewPager2 vp, vp1, vp2;
    int[] imgIDs =new int[]{R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};
    String[] Urls= new String[]{"https://vexere.com/vi-VN/bai-viet/nha-xe-giam-gia-hai-phong-travel",
            "https://vexere.com/vi-VN/bai-viet/dat-ve-xe-khach-khu-hoi",
            "https://vexere.com/vi-VN/referral?utm_source=banner&utm_medium=main&utm_campaign=referral_main_banner_2023",
            "https://vexere.com/vi-VN/bai-viet/uu-dai-bat-ngo"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timkiem, container, false);
        Button bttimkiem = view.findViewById(R.id.bttimkiem);

//Phần tin tức, ưu đãi


        ntext= view.findViewById(R.id.NewsTxt);
        ntext1= view.findViewById(R.id.NewsTxt1);
        ntext2= view.findViewById(R.id.NewsTxt2);
        // Initialize ViewPager2
        vp = view.findViewById(R.id.News);
        vp1 = view.findViewById(R.id.News1);
        vp2 = view.findViewById(R.id.News2);

        // Create News adapters
        News n = new News(getContext(), imgIDs, Urls);
        News n1 = new News(getContext(), imgIDs, Urls);
        News n2 = new News(getContext(), imgIDs, Urls);
        vp.setAdapter(n);
        vp1.setAdapter(n1);
        vp2.setAdapter(n2);
        bttimkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChuyenDiFragment chuyendi = new ChuyenDiFragment();

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, chuyendi);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView noidi = view.findViewById(R.id.tvNoidi);
        noidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityFragment city = new CityFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, city);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView noiden = view.findViewById(R.id.tvNoiden);
        noiden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityFragment cityden = new CityFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, cityden);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView ngaydi = view.findViewById(R.id.tvNgaydi);
        ngaydi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NgaydiFragment ngaydi = new NgaydiFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, ngaydi);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        Bundle bundle = getArguments();
        if(bundle !=null)
        {
            String tinhdi = bundle.getString("Tinhdi");
            String tinhden = bundle.getString("Tinhden");
            noidi.setText(tinhdi);
            noiden.setText(tinhden);
        }

        return view;

    }


}

