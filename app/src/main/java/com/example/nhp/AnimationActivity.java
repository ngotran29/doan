package com.example.nhp;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifDrawable;

public class AnimationActivity extends AppCompatActivity {
    GifImageView  logoAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        logoAnim = findViewById(R.id.logoAnim);
        logoAnim.setImageResource(R.drawable.logo);
        //animation
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                gotoHomeScreen();
                finish();
            }
        }, 1500);
        showAnimation();

    }
    void gotoHomeScreen() {
        Intent i = new Intent(AnimationActivity.this, MainActivity.class);
        startActivity(i);
    }
    void showAnimation() {
        Animation animation= AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.rotate_move_down);
        logoAnim.startAnimation(animation);
    }
}