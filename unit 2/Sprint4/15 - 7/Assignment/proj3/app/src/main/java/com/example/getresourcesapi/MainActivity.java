package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtId;
    private Button mBtnSecondScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtId = findViewById(R.id.etId);
        mBtnSecondScreen = findViewById(R.id.btnSecondScreen);
        mBtnSecondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Id" , mEtId.getText().toString());
                startActivity(intent);
            }
        });
    }
}