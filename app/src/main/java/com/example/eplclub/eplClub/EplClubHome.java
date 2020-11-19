package com.example.eplclub.eplClub;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.eplclub.R;
import com.example.eplclub.databinding.FragmentEplClubHomeBinding;
import com.example.eplclub.model.EplClubModel;
import com.example.eplclub.model.Players;

import java.util.ArrayList;
import java.util.List;


public class EplClubHome extends Fragment {

    private FragmentEplClubHomeBinding binding;
    private EplClubHomeViewModel viewModel;


    public EplClubHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        List<EplClubModel> eplClubList = new ArrayList<>();



//        Manchester United
        List<Players> mu = new ArrayList<>();
        mu.add(new Players("David de Gea", "GoalKeeper", "1"));
        mu.add(new Players("Dean Henderson", "GoalKeeper", "26"));
        mu.add(new Players("Luke Shaw", "Defender", "23"));
        mu.add(new Players("Alex Telles", "Defender", "27"));
        mu.add(new Players("Teden Mengi", "Defender", "43"));
        mu.add(new Players("Paul Pogba", "MidFielder", "6"));
        mu.add(new Players("Juan Mata", "Midfielder", "8"));
        mu.add(new Players("Jesse Lingard", "Midfielder", "14"));
        mu.add(new Players("Marcus RashFord", "Forward", "10"));
        mu.add(new Players("Anthony Martial", "Forward", "9"));
        mu.add(new Players("Edison Cavani", "Forward", "7"));
        eplClubList.add(new EplClubModel("Manchester United", mu, R.drawable.manchester_united));

//        Arsenal
        List<Players> ars = new ArrayList<>();
        ars.add(new Players("Bernd Leno", "GoalKeeper", "1"));
        ars.add(new Players("Matt Macey", "GoalKeeper", "33"));
        ars.add(new Players("Hector Bellerin", "Defender", "2"));
        ars.add(new Players("David Luiz", "Defender", "23"));
        ars.add(new Players("Rob Holding", "Defender", "16"));
        ars.add(new Players("Mezut Ozil", "Midfielder", "10"));
        ars.add(new Players("Granit Xhaka", "Midfielder", "34"));
        ars.add(new Players("Bukayo Saka", "Midfielder", "7"));
        ars.add(new Players("Pierre-Emerick Aubameyang", "Forward", "14"));
        ars.add(new Players("Alexandre Lacazette", "Forward", "9"));
        ars.add(new Players("Dani Ceballos", "Forward", "8"));
        eplClubList.add(new EplClubModel("Arsenal", ars, R.drawable.arsenal));






//

//

        EplClubHomeViewModelFactory eplClubHomeViewModelFactory = new EplClubHomeViewModelFactory(eplClubList);
        viewModel = new ViewModelProvider(this,eplClubHomeViewModelFactory).get(EplClubHomeViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_epl_club_home, container,false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupClub();
    }

    public void setupClub(){
        RecyclerView recyclerView = binding.reyclerView;
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        ClubAdapter adapter = new ClubAdapter(new OnItemClubListener() {
            @Override
            public void onImageClicked(EplClubModel eplClubModel) {
                viewModel.onImageClicked(eplClubModel);
            }
        });
        recyclerView.setAdapter(adapter);
        viewModel.listLiveData().observe(getViewLifecycleOwner(), new Observer<List<EplClubModel>>() {
            @Override
            public void onChanged(List<EplClubModel> eplClubModels) {
                adapter.setEplClubModels(eplClubModels);
            }
        });

        viewModel.Navigatedetail().observe(getViewLifecycleOwner(), new Observer<EplClubModel>() {
            @Override
            public void onChanged(EplClubModel eplClubModel) {
                if(eplClubModel!=null){
                    NavDirections action = EplClubHomeDirections.actionEplClubHomeToDetails(eplClubModel);
                    Navigation.findNavController(requireView()).navigate(action);
                    viewModel.detailNavigated();
                }
            }
        });

    }
}