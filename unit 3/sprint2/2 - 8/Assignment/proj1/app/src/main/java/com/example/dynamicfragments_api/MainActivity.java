package com.example.dynamicfragments_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnFragmentA;
    private Button mBtnFragmentB;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initViews();
    }

    private void initViews() {
        mBtnFragmentA = findViewById(R.id.btnFragmentA);
        mBtnFragmentB = findViewById(R.id.btnFragmentB);
        mBtnFragmentA.setOnClickListener(this);
        mBtnFragmentB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnFragmentA:
                addA();
                break;
            case R.id.btnFragmentB:
                replaceAWithB();

        }
    }

    private void replaceAWithB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB).commit();
    }

    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer, fragmentA, "FragmentA").commit();
    }
}