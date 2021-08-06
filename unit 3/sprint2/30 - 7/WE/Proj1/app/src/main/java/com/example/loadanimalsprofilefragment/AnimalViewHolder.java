package com.example.loadanimalsprofilefragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvAnimalImage;
    private TextView mTvAnimalName;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvAnimalImage = itemView.findViewById(R.id.ivAnimalImage);
        mTvAnimalName = itemView.findViewById(R.id.tvAnimalName);
    }

    public void setData(AnimalModel animalModel) {
        Glide.with(mIvAnimalImage).load(animalModel.getAnimalImage()).into(mIvAnimalImage);
        mTvAnimalName.setText(animalModel.getAnimalName());
    }
}
