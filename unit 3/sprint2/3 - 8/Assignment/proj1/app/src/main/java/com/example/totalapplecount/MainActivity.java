package com.example.totalapplecount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.totalapplecount.Fragment.BuyApplesFragment;
import com.example.totalapplecount.Fragment.TotalApplesFragment;
import com.example.totalapplecount.Interface.CommunicationListener;

public class MainActivity extends AppCompatActivity implements CommunicationListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchTotalApple();
    }

    private void launchTotalApple() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        fragmentTransaction.add(R.id.flContainer, totalApplesFragment, "totalApplesFragment").commit();
    }

    @Override
    public void listener(Bundle bundle, String tag) {
        if (tag.equals("totalApplesFragment")) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
            buyApplesFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.flContainer, buyApplesFragment, "buyApplesFragment").commit();
        } else if (tag.equals("buyApplesFragment")) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
            totalApplesFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.flContainer, totalApplesFragment, "totalApplesFragment").commit();
        }
    }
}