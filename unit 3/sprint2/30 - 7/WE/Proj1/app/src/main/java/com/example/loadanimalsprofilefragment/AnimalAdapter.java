package com.example.loadanimalsprofilefragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    private ArrayList<AnimalModel> animalModelArrayList;

    public AnimalAdapter(ArrayList<AnimalModel> animalModelArrayList) {
        this.animalModelArrayList = animalModelArrayList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        AnimalModel animalModel = animalModelArrayList.get(position);
        holder.setData(animalModel);
    }

    @Override
    public int getItemCount() {
        return animalModelArrayList.size();
    }
}
