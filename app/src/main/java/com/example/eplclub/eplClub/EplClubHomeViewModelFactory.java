package com.example.eplclub.eplClub;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.eplclub.model.EplClubModel;

import java.util.List;

public class EplClubHomeViewModelFactory implements ViewModelProvider.Factory {
    private List<EplClubModel> eplClubModelList;

    public EplClubHomeViewModelFactory(List<EplClubModel> eplClubModelList) {
        this.eplClubModelList = eplClubModelList;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(EplClubHomeViewModel.class)){
            return (T) new EplClubHomeViewModel(eplClubModelList);
        }
        throw new IllegalArgumentException("Must EplClubViewModel");
    }
}
