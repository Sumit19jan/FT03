package com.example.idenditycard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView recyclerView;
    private ArrayList<IdentityCard> identityCardArrayList;
    private IdentityCardAdapter identityCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        identityCardAdapter = new IdentityCardAdapter(identityCardArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(identityCardAdapter);
    }

    private void buildData() {
        identityCardArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                identityCardArrayList.add(new IdentityCard("MicroSoft",
                        R.drawable.bill_gates, 64, "Buisness"));
            } else if (i % 3 == 1) {
                identityCardArrayList.add(new IdentityCard("Amazon",
                        R.drawable.jeff_bezos, 56, "Buisness"));
            } else if (i % 3 == 2) {
                identityCardArrayList.add(new IdentityCard("Masai School",
                        R.drawable.prateek_sukla, 31, "Buisness"));
            }
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void itemClicked(IdentityCard identityCard) {
        new AlertDialog.Builder(this)
                .setTitle("Company Details")
                .setMessage(
                        identityCard.getCompanyName() + "\n"
                                + identityCard.getAge() + "\n"
                                + identityCard.getProfession()
                ).
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