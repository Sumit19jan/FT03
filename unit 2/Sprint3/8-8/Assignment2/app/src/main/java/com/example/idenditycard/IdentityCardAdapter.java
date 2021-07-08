package com.example.idenditycard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IdentityCardAdapter extends RecyclerView.Adapter<IdentityCardViewHolder> {

    private ArrayList<IdentityCard> identityCardArrayList;
    private ItemClickListener itemClickListener;

    public IdentityCardAdapter(ArrayList<IdentityCard> identityCardArrayList,
                               ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        this.identityCardArrayList = identityCardArrayList;
    }

    @NonNull
    @Override
    public IdentityCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,
                false);
        return new IdentityCardViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull IdentityCardViewHolder holder, int position) {
        IdentityCard identityCard = identityCardArrayList.get(position);
        holder.setData(identityCard);
    }

    @Override
    public int getItemCount() {
        return identityCardArrayList.size();
    }
}
