package com.example.ft_and_03_u_2_c_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSignMainActivity;
    private Button mBtnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListeners();
    }

    private void initListeners() {
        mBtnSignMainActivity = findViewById(R.id.btnSignMainActivity);
        mBtnCreateAccount = findViewById(R.id.btnCreateAccount);
        mBtnSignMainActivity.setOnClickListener(this);
        mBtnCreateAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnCreateAccount:
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSignMainActivity:
                Intent intent1 = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent1);
                break;
        }

    }
}