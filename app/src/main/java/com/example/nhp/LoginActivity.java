package com.example.nhp;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    Button btLogin, btResgister;
    EditText edUserName, edPassWord;
    private final Gson gson = new Gson();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        taosukien();
    }

    private void taosukien() {
        btLogin.setOnClickListener(v -> checkUserLogin());
        btResgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, Register.class);
                startActivity(i);
            }
        });
    }

    private void anhxa() {
        btLogin = findViewById(R.id.btnLogin);
        btResgister = findViewById(R.id.btnRegister);
        edUserName = findViewById(R.id.edUsername);
        edPassWord = findViewById(R.id.edPassWord);
    }

    private void checkUserLogin() {
        String usePre = sharedPreferences.getString(Utils.KEY_USER, null);
        User user = gson.fromJson(usePre, User.class);

        // user = null == chưa đăng ký
        if (user == null) {
            return;
        }

        // kiểm tra user name và pass có trùng với đối tượng user trong share pre hay không
        boolean isValid = edUserName.getText().toString().trim().equals(user.getUserName()) &&
                edPassWord.getText().toString().trim().equals(user.getPassword());

        if (isValid) {
            Intent intent = new Intent(LoginActivity.this, TaikhoanFragment.class);
//            // Khởi tạo bundle để truyền data qua cho TaiKhoanFragment
//            Bundle bundle = new Bundle();
//
//            // Đặt giá trị của edUsername vào bundle
//            bundle.putString(Utils.KEY_USERNAME, edUserName.getText().toString().trim());
//
//            // Vì user là object nên dùng putSerializable
//            bundle.putSerializable(Utils.KEY_USER_PROFILE, user);
//
//            // Put bundle cho intent
//            intent.putExtras(bundle);
//            startActivity(intent);
            Intent i = new Intent();
            String userName = edUserName.getText().toString();

            i.putExtra(Utils.KEY_USERNAME,edUserName.getText().toString());
            setResult(296,i);
            finish();
        }
    }
}
