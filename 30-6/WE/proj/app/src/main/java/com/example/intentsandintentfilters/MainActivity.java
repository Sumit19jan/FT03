package com.example.intentsandintentfilters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtUserName;
    private EditText mEtEMail;
    private EditText mETPassword;
    private Button mBtnLogin;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmailValid() && isPassword() && isUserNameValid()) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("UserName", mEtUserName.getText().toString());
                    startActivity(intent);
                }

            }
        });

    }

    private void initViews() {
        mEtUserName = findViewById(R.id.etUserName);
        mEtEMail = findViewById(R.id.etEmail);
        mETPassword = findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.btnLogin);
    }

    private boolean isEmailValid() {
        if (mEtEMail.getText().toString().length() >= 1 &&
                mEtEMail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEMail.setError("Invalid Email");
            return false;
        }
    }

    private boolean isPassword() {
        if (mETPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mETPassword.setError("Password is not Valid");
            return false;
        }
    }

    private boolean isUserNameValid() {
        if (mEtUserName.getText().toString().length() >= 4) {
            return true;
        }
        return false;
    }
}