package com.example.eplclub.eplClubDetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eplclub.databinding.ClubLogosBinding;
import com.example.eplclub.databinding.PlayersDetailsBinding;
import com.example.eplclub.eplClub.ClubAdapter;
import com.example.eplclub.model.Players;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {
    private List<Players> playersList;

    public DetailsAdapter(List<Players> playersList) {
        this.playersList = playersList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PlayersDetailsBinding playersDetailsBinding = PlayersDetailsBinding.inflate(layoutInflater,parent,false);
        return new DetailsViewHolder(playersDetailsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        Players players = playersList.get(position);
        holder.bind(players);
    }

    @Override
    public int getItemCount() {
        if(playersList!=null){
            return playersList.size();
        }else{
            return 0;
        }
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
    private PlayersDetailsBinding binding;

        public DetailsViewHolder(@NonNull PlayersDetailsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Players players){
            binding.setPlayers(players);
            binding.executePendingBindings();
        }
    }
}
