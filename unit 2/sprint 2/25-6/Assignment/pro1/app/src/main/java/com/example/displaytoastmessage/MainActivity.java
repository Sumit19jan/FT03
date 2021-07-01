package com.example.displaytoastmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnButtonOne;
    private Button mBtnButtonTwo;
    private Button mBtnButtonThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListeners();
    }

    private void initListeners() {
        mBtnButtonOne = findViewById(R.id.btnButtonOne);
        mBtnButtonTwo = findViewById(R.id.btnButtonTwo);
        mBtnButtonThree = findViewById(R.id.btnButtonThree);
        mBtnButtonOne.setOnClickListener(this);
        mBtnButtonTwo.setOnClickListener(this);
        mBtnButtonThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnButtonOne:
                Toast.makeText(MainActivity.this, "Button one clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnButtonTwo:
                Toast.makeText(MainActivity.this, "Button two clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnButtonThree:
                Toast.makeText(MainActivity.this, "Button three clicked", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}