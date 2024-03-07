package com.example.nhp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView mnBottom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnBottom = findViewById(R.id.navMenu);
        mnBottom.setOnItemSelectedListener(getItemSelectedListener());

        loadFragment(new TimkiemFragment());

        setTitleToolbar();



    }


    @NonNull
    private NavigationBarView.OnItemSelectedListener getItemSelectedListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mnTimkiem) {
                    loadFragment(new TimkiemFragment());

                } else if (item.getItemId() == R.id.mnVe) {
                    loadFragment(new VeFragment());
                } else if (item.getItemId() == R.id.mnThongbao) {
                    loadFragment(new ThongbaoFragment());
                } else {
                    loadFragment(new TaikhoanFragment());
                }
                return true;
            }
        };
    }

    void loadFragment(Fragment fragment) {
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fragment);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }

    private void setTitleToolbar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Main Activity");
        }
    }


}


