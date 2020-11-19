package com.example.eplclub.eplClubDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eplclub.R;
import com.example.eplclub.databinding.FragmentDetailsBinding;
import com.example.eplclub.model.EplClubModel;


public class Details extends Fragment {

    private EplClubModel eplClubModel;
    private FragmentDetailsBinding binding;

    public Details() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        eplClubModel = DetailsArgs.fromBundle(getArguments()).getTeam();
        setupPlayer();
    }

    public void setupPlayer(){
        binding.detailRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.detailRecycler.setAdapter(new DetailsAdapter(eplClubModel.getPlayers()));
    }
}