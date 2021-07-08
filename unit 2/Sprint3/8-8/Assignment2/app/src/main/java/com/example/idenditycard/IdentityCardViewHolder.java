package com.example.idenditycard;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IdentityCardViewHolder extends RecyclerView.ViewHolder {

    private RelativeLayout relativeLayout;
    private TextView mTvCompanyName;
    private TextView mTvAge;
    private TextView mTvProfession;
    private ImageView mIvImage;
    private ItemClickListener itemClickListener;


    public IdentityCardViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        relativeLayout = itemView.findViewById(R.id.relativeLayout);
        mTvCompanyName = itemView.findViewById(R.id.tvCompanyName);
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvProfession = itemView.findViewById(R.id.tvProfession);
    }

    public void setData(IdentityCard identityCard) {
        mTvCompanyName.setText(identityCard.getCompanyName());
        mIvImage.setImageResource(identityCard.getImageId());
        mTvAge.setText(identityCard.getAge() + "");
        mTvProfession.setText(identityCard.getProfession());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.itemClicked(identityCard);
            }
        });
    }
}
