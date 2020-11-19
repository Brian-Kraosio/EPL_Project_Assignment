package com.example.eplclub.eplClub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eplclub.databinding.ClubLogosBinding;
import com.example.eplclub.model.EplClubModel;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {
    private List<EplClubModel> eplClubModels;
    private OnItemClubListener onItemClubListener;

    public ClubAdapter() {
    }

    public ClubAdapter(List<EplClubModel> eplClubModels) {
        this.eplClubModels = eplClubModels;
    }

    public ClubAdapter(OnItemClubListener onItemClubListener) {
        this.onItemClubListener = onItemClubListener;
    }

    public ClubAdapter(List<EplClubModel> eplClubModels, OnItemClubListener onItemClubListener) {
        this.eplClubModels = eplClubModels;
        this.onItemClubListener = onItemClubListener;
    }

    public void setEplClubModels(List<EplClubModel> eplClubModels) {
        this.eplClubModels = eplClubModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ClubLogosBinding clubLogosBinding = ClubLogosBinding.inflate(layoutInflater,parent,false);
        return new ClubViewHolder(clubLogosBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder holder, int position) {
        EplClubModel eplClubModel = eplClubModels.get(position);
        holder.bind(eplClubModel, onItemClubListener);
    }

    @Override
    public int getItemCount() {
        if(eplClubModels!=null){
            return eplClubModels.size();
        }else{
            return 0;
        }
    }

    public class ClubViewHolder extends RecyclerView.ViewHolder {
        private ClubLogosBinding binding;

        public ClubViewHolder(ClubLogosBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(EplClubModel eplClubModel, OnItemClubListener onItemClubListener){
            binding.setClub(eplClubModel);
            binding.setClickListener(onItemClubListener);
            binding.executePendingBindings();
        }
    }
}
