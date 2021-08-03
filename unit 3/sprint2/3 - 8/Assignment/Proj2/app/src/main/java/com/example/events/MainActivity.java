package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.events.Fragment.EventDetailsFragment;
import com.example.events.Fragment.PriceDetailsFragment;
import com.example.events.Fragment.TimeAndDateFragment;
import com.example.events.Interface.CommunicationListener;

public class MainActivity extends AppCompatActivity implements CommunicationListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchEventDetailsFragment();
    }

    private void launchEventDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
        fragmentTransaction.replace(R.id.flContainer, eventDetailsFragment, "eventDetailsFragment").commit();
    }

    @Override
    public void listener(Bundle bundle, String Tag) {
        if (Tag.equals("eventDetailsFragment")) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
            timeAndDateFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.flContainer, timeAndDateFragment, "timeAndDateFragment").commit();
        } else if (Tag.equals("timeAndDateFragment")) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
            priceDetailsFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.flContainer, priceDetailsFragment, "priceDetailsFragment").commit();
        }
    }
}