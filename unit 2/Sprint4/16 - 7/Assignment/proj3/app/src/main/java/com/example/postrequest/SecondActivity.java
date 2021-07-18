package com.example.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private TextView mTvEmail;
    private TextView mTvRequestType;
    private TextView mTvId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        getValuesFromIntent();
    }

    private void getValuesFromIntent() {
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String title = intent.getStringExtra("title");
        String requestType = intent.getStringExtra("requestType");
        String Id = (intent.getStringExtra("id"));
        mTvTitle.setText(title);
        mTvEmail.setText(email);
        mTvRequestType.setText(requestType);
        mTvId.setText(Id+"");
    }

    private void initViews() {
        mTvEmail = findViewById(R.id.tvEmail);
        mTvTitle = findViewById(R.id.tvTitle);
        mTvRequestType = findViewById(R.id.tvRequestType);
        mTvId = findViewById(R.id.tvId);
    }
}