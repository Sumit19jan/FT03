package com.example.birdsgridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView recyclerView;
    private ArrayList<BirdModel> birdModelArrayList = new ArrayList<>();
    private BirdAdapter birdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        birdAdapter = new BirdAdapter(birdModelArrayList, this);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(birdAdapter);
    }

    private void buildData() {
        for (int i = 0; i < 100; i++) {
            if (i % 4 == 0) {
                birdModelArrayList.add(new BirdModel("BlueBird", R.drawable.blue_bird));
            } else if (i % 4 == 1) {
                birdModelArrayList.add(new BirdModel("HummingBird", R.drawable.humming_bird));
            } else if (i % 4 == 2) {
                birdModelArrayList.add(new BirdModel("Parrot", R.drawable.parrot));
            } else if (i % 4 == 3) {
                birdModelArrayList.add(new BirdModel("HummingBird", R.drawable.humming_bird));
            }
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void itemClicked(BirdModel birdModel) {
        new AlertDialog.Builder(this)
                .setTitle("Bird Name")
                .setMessage(
                        birdModel.getName()).
                setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).
                setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).
                show();
    }
}