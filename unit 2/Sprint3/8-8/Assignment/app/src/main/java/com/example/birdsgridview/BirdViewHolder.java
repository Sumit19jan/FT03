package com.example.birdsgridview;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BirdViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivBirdImage;
    private ItemClickListener itemClickListener;
    private LinearLayout linearLayout;

    public BirdViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View view) {
        ivBirdImage = view.findViewById(R.id.ivBirdImage);
        linearLayout = view.findViewById(R.id.linearLayout);
    }

    public void setData(BirdModel birdModel) {
        ivBirdImage.setImageResource(birdModel.getImageId());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.itemClicked(birdModel);
            }
        });
    }
}
