package com.example.nhp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.nhp.classes.ProgressHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


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
//                Intent i = new Intent(LoginActivity.this, TaikhoanFragment.class);
//                i.putExtra("","");
//                startActivity(i);
//                finish();
                onClickSignIn();
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
    private void onClickSignIn(){
        String strUser = edt_user_login.getText().toString().trim();
        String strPass = edt_pass_login.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Người dùng đã đăng nhập, chuyển đến màn hình mới
            Intent intent = new Intent(LoginActivity.this, TaikhoanFragment.class);
            startActivity(intent);
            finishAffinity();
        }
        ProgressHelper.showDialog(LoginActivity.this,"Loading...");
        auth.signInWithEmailAndPassword(strUser, strPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        ProgressHelper.dismissDialog();
                        if (task.isSuccessful()) {
                           Intent intent = new Intent(LoginActivity.this,TaikhoanFragment.class);
                           startActivity(intent);
                           finishAffinity();
                        } else {

                            Toast.makeText(LoginActivity.this, "Đăng nhập thất bại",
                                    Toast.LENGTH_SHORT).show();

                        }
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


