package com.example.nhp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterOtpActivity extends AppCompatActivity {

    private EditText edt_otp;
    private Button btn_send_otp;
    private TextView tv_send_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        initUi();
        setTitleToolbar();
        btn_send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strOtp = edt_otp.getText().toString().trim();
                onClickSendOtpCode(strOtp);
            }
        });
        tv_send_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSendOtpAgain();
            }
        });
    }


    private void setTitleToolbar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Enter OTP Code");
        }
    }
    private void initUi(){
        btn_send_otp = findViewById(R.id.btn_send_otp);
        edt_otp = findViewById(R.id.edt_otp);
        tv_send_again = findViewById(R.id.tv_send_again);
    }
    private void onClickSendOtpAgain() {
    }

    private void onClickSendOtpCode(String strOtp) {

    }
}