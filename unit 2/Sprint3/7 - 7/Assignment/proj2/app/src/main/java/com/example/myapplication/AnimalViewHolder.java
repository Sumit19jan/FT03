package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvImage;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        mIvImage = itemView.findViewById(R.id.ivImage);
    }

    public void setData(AnimalModel animalModel){

        mIvImage.setImageResource(animalModel.getImageId());
        mIvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mIvImage.getContext(), animalModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
