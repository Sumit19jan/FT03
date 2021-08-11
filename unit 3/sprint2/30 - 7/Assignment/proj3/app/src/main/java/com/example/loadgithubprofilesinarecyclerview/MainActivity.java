package com.example.loadgithubprofilesinarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchFragment();
    }

    private void launchFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        GitHubFragment gitHubFragment = new GitHubFragment();
        fragmentTransaction.add(R.id.flContainer,gitHubFragment,"gitHubFragment").commit();
    }
}