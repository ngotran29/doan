package com.example.nhp;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class LoginActivity extends AppCompatActivity {
    Button btLogin, btSignUp,buttonForgotPassword;
    EditText edt_pass_login,edt_user_login ;
    ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btLogin = findViewById(R.id.btLogin);
        btSignUp = findViewById(R.id.buttonSignUp);
        buttonForgotPassword = findViewById(R.id.buttonForgotPassword);
        edt_pass_login = findViewById(R.id.edt_pass_login);
        edt_user_login = findViewById(R.id.edt_user_login);
        imageView = findViewById(R.id.imageView);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, TaikhoanFragment.class);
                i.putExtra("","");
                startActivity(i);
                finish();
            }
        });
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, Register.class);
                startActivity(i);
            }
        });
    }

//    private void showUserInformation(){
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if ( user == null){
//            return;
//        }
//        String name = user.getDisplayName();
//        String email = user.getEmail();
//        Uri photoUrl = user.getPhotoUrl();
//
//        edt_user_login.setText(name);
//        edt_pass_login.setText(email);
//        Glide.with(this).load(photoUrl).error(R.drawable.user).into(imageView);
//
//    }


}


