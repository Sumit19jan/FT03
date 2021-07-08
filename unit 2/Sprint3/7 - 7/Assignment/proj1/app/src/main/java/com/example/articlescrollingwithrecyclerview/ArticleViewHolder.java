package com.example.articlescrollingwithrecyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    private TextView mTvTitle;
    private TextView mTvAuthor;
    private LinearLayout linearLayout;
    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mTvAuthor = itemView.findViewById(R.id.tvAuthor);
        linearLayout = itemView.findViewById(R.id.linearLayout);
    }

    public void setArticle(Article article) {
        mIvImage.setBackgroundResource(article.getImageId());
        mTvTitle.setText(article.getTitle());
        mTvAuthor.setText(article.getAuthor());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(linearLayout.getContext(), article.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
