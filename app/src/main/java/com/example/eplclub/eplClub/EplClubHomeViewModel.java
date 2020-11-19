package com.example.eplclub.eplClub;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eplclub.model.EplClubModel;

import java.util.List;

public class EplClubHomeViewModel extends ViewModel {
    private MutableLiveData<List<EplClubModel>> eplClubModelMutableLiveData = new MutableLiveData<>();
    private List<EplClubModel> eplClubModelList = null;

    public EplClubHomeViewModel(List<EplClubModel> eplClubModelList) {
        this.eplClubModelList = eplClubModelList;
        this.eplClubModelMutableLiveData.setValue(eplClubModelList);
    }

    public LiveData<List<EplClubModel>> listLiveData (){
        return eplClubModelMutableLiveData;
    }

    private MutableLiveData<EplClubModel> details = new MutableLiveData<>();

    public LiveData<EplClubModel> Navigatedetail(){
        return details;
    }

    public void onImageClicked(EplClubModel eplClubModel){
        details.setValue(eplClubModel);
    }

    public void detailNavigated(){
        details.setValue(null);
    }


}
