package com.example.articlescrollingwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Article> articleArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildData();
        initViews();
    }

    private void buildData() {
        articleArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                Article article = new Article(R.drawable.ocean, "Blue Ocean \n Waves Crashed"
                        , "see the beautiful ocean of the \\n pacific coast where the water is so\n" +
                        "clean and you can see sand");
                articleArrayList.add(article);
            } else if (i % 2 == 1) {
                Article article1 = new Article(R.drawable.bridge, "Blue Ocean \n Waves Crashed"
                        , "see the beautiful ocean of the \\n pacific coast where the water is so\n" +
                        "clean and you can see sand");
                articleArrayList.add(article1);
            }
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rvRecyclerView);
        ArticleAdapter articleAdapter = new ArticleAdapter(articleArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(articleAdapter);
    }

}