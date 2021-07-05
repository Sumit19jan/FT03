package com.example.ft_and_03_u_2_c_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTvName_HomeActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvName_HomeActivity = findViewById(R.id.tvName_HomeActivity);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Name");
        mTvName_HomeActivity.setText(str);
    }
}