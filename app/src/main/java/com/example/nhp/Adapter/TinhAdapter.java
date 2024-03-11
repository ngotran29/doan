package com.example.nhp.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhp.R;
import com.example.nhp.TimkiemFragment;
import com.example.nhp.Tinhthanh;

import java.util.List;

public class TinhAdapter extends RecyclerView.Adapter<TinhAdapter.TinhViewHoler> {
    List<Tinhthanh> lstinhthanh;
    TinhAdapter tinhAdapter;
    private OnItemClickListener listener;
    private FragmentManager fragmentManager;


    public interface OnItemClickListener {
        void onItemClick(String cityName);
    }

    public TinhAdapter(List<Tinhthanh> lstinhthanh, FragmentManager fragmentManager) {
        this.lstinhthanh = lstinhthanh;
        this.fragmentManager = fragmentManager;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public TinhViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_tinh, parent, false);
        return new TinhViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TinhViewHoler holder, int position) {
        Tinhthanh tinhthanh = lstinhthanh.get(position);
        if (tinhthanh == null) {
            return;
        }
        holder.tentinh.setText(tinhthanh.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(tinhthanh.getName());
                }
            }
        });
    }
    private void onCityItemSelected(String cityName) {
        Bundle bundle = new Bundle();
        bundle.putString("selectedCityName", cityName);

        TimkiemFragment timkiemFragment = new TimkiemFragment();
        timkiemFragment.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment, timkiemFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



    @Override
    public int getItemCount() {
        if (lstinhthanh != null) {
            return lstinhthanh.size();
        }
        return 0;
    }

    public class TinhViewHoler extends RecyclerView.ViewHolder {

        TextView tentinh;

        public TinhViewHoler(@NonNull View itemView) {
            super(itemView);
            tentinh = itemView.findViewById(R.id.tv_item_ten_tinh);
        }
    }

}