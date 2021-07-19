package com.example.sprint_4_evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    private EditText mEtEmail;
    private EditText mETPassword;
    private CheckBox mCheckBox;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mETPassword = findViewById(R.id.etPassword);
        mCheckBox = findViewById(R.id.checkBox);
        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidEmail() && isValidPassword()) {
                    Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValidPassword() {
        boolean check = false;
        if (mETPassword.getText().toString().length() >= 6) {
            check = true;
        } else {
            mETPassword.setError("Password is very short");
            check = false;
        }
        return check;
    }

    private boolean isValidEmail() {
        boolean check = false;
        if (mEtEmail.getText().toString().contains("@gmail.com")) {
            check = true;
        } else {
            mEtEmail.setError("InValid Email");
            check = false;
        }
        return check;
    }
}