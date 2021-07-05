package com.example.ft_and_03_u_2_c_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtName;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtnSignUp_SignUpActivity;
    private TextView mTvSignIn_SignUpActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViewsAndListeners();
    }

    private void initViewsAndListeners() {
        mEtName = findViewById(R.id.etName);
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mBtnSignUp_SignUpActivity = findViewById(R.id.btnSignUpSignUpActivity);
        mTvSignIn_SignUpActivity = findViewById(R.id.tvSignInSignUpActivity);
        mBtnSignUp_SignUpActivity.setOnClickListener(this);
        mTvSignIn_SignUpActivity.setOnClickListener(this);
    }

    private boolean validPass() {
        if (mEtPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mEtName.setError("Week Password");
            return false;
        }
    }

    private boolean validName() {
        if (mEtName.getText().toString().length() >= 4) {
            return true;
        } else {
            mEtName.setError("Name Must be greater than 4 char");
            return false;
        }
    }

    private boolean validEmail() {
        if (mEtEmail.getText().toString().contains("@gmail.com")) {
            return true;
        } else {
            mEtEmail.setError("Invalid Email");
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnSignUpSignUpActivity:
                if (validName()){
                    if (validEmail()){
                        if (validPass()){
                            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                            intent.putExtra("Name", mEtName.getText().toString());
                            startActivity(intent);
                            break;
                        }
                    }

                }
            case R.id.tvSignInSignUpActivity:
                Intent intent1 = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
