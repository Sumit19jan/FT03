package com.example.ft_and_03_u_2_c_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private EditText mEtName_SignActivity;
    private EditText mEtEmail_SignActivity;
    private EditText mEtPassword_SignActivity;
    private Button mBtnSignIn_SignActivity;
    private TextView mTvSignUp_SignActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initViewsAndListeners();
    }

    private void initViewsAndListeners() {
        mEtName_SignActivity = findViewById(R.id.etName_SignIn);
        mEtEmail_SignActivity = findViewById(R.id.etEmail_SignIn);
        mEtPassword_SignActivity = findViewById(R.id.etPassword_SignIn);
        mBtnSignIn_SignActivity = findViewById(R.id.btnSignIn_SignInActivity);
        mTvSignUp_SignActivity = findViewById(R.id.tvSignUp_SignIn);
        mBtnSignIn_SignActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                intent.putExtra("Name", mEtName_SignActivity.getText().toString());
                startActivity(intent);
            }
        });

        mTvSignUp_SignActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent1);
            }
        });
    }
}