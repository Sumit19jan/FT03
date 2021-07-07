package com.example.recyclerview_we;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        StudentAdapter studentAdapter = new StudentAdapter(studentList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    private void buildList() {
        Student student2 = new Student("Sumit", 21, "EMP1235");
        studentList.add(student2);
        for (int i = 0; i < 13; i++) {
            Student student1 = new Student("XYZ" + i, 21, "EMP1235");
            studentList.add(student1);
        }

    }

    private void initView() {
        recyclerView = findViewById(R.id.rvRecyclerView);
    }
}