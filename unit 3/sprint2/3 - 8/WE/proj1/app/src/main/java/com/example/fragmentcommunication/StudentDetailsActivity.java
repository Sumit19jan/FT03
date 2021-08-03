package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class StudentDetailsActivity extends AppCompatActivity implements CommunicationListener {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchStudentPersonalDetailsFragment();
    }

    private void launchStudentPersonalDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPersonalDetailsFragment studentPersonalDetailsFragment = new StudentPersonalDetailsFragment();
        fragmentTransaction.add(R.id.container, studentPersonalDetailsFragment, "personal").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment studentPerformanceDetailsFragment = new StudentPerformanceDetailsFragment();
        studentPerformanceDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container,studentPerformanceDetailsFragment,"Performance").addToBackStack("").commit();
    }
}