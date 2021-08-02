package com.example.fragment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAddA;
    private Button mBtnRemoveA;
    private Button mBtnReplaceAWithBWithBackstack;
    private Button mBtnReplaceAwithBwithoutbackstack;
    private Button mBtnAddB;
    private Button mBtnRemoveB;
    private Button mBtnReplaceBWithA;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        mBtnAddA = findViewById(R.id.btnAddA);
        mBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnReplaceAwithBwithoutbackstack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnReplaceAWithBWithBackstack = findViewById(R.id.btnReplaceAWithB);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        mBtnAddA.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnReplaceAwithBwithoutbackstack.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnReplaceBWithA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnReplaceAWithB:
                replaceAwithBWithBackStack();
                
                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                replaceAWithB();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceBWithA:
                replaceBWithA();
                break;
        }
    }

    private void replaceAwithBWithBackStack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer,fragmentB,"fragmentA").addToBackStack("fragB").commit();
    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if (fragmentB != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB).commit();
        }
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA).commit();
        }
    }

    private void replaceBWithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer,fragmentA,"fragmentB").commit();
    }

    private void replaceAWithB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer,fragmentB,"fragmentA").commit();
    }

    private void addB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer,fragmentB,"fragmentB").commit();
    }

    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer,fragmentA,"fragmentA").commit();
    }
}