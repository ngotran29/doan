package com.example.nhp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nhp.Adapter.TinhAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CityFragment extends Fragment   {

    RecyclerView rvtinh;
    TinhAdapter tinhAdapter;
    ArrayList<Tinhthanh> lstinhthanh;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        rvtinh = view.findViewById(R.id.rvtinh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvtinh.setLayoutManager(linearLayoutManager);
        lstinhthanh = new ArrayList<>();
        tinhAdapter = new TinhAdapter(lstinhthanh, getParentFragmentManager());
        rvtinh.setAdapter(tinhAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rvtinh.addItemDecoration(dividerItemDecoration);
        getListTinhfromFDB();
        tinhAdapter.setOnItemClickListener(this::onCityItemSelected);
        return view;
    }
    private void onCityItemSelected(String cityName) {
        Bundle bundle = new Bundle();
        bundle.putString("selectedCityName", cityName);

        TimkiemFragment timkiemFragment = new TimkiemFragment();
        timkiemFragment.setArguments(bundle);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment, timkiemFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void getListTinhfromFDB() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_tinh");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Tinhthanh tinhthanh = dataSnapshot.getValue(Tinhthanh.class);
                    lstinhthanh.add(tinhthanh);
                }
                tinhAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                if (getContext() == null) {
                    Log.e("CityFragment", "getContext() trả về null");
                } else {
                    // Thực hiện các hoạt động khác ở đây
                    Toast.makeText(getContext(), "lấy list không thành công", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}