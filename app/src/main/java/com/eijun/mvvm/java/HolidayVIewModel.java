package com.eijun.mvvm.java;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class HolidayVIewModel extends ViewModel {

    private HolidayRepo holidayRepo;
    private MutableLiveData<List<HolidayModel>> mutableLiveData ;

    public HolidayVIewModel(){
        holidayRepo = new HolidayRepo() ;
    }

    public LiveData<List<HolidayModel>> getHolidays () {
        if (mutableLiveData==null) {
            mutableLiveData = holidayRepo.requestHoliday();
        }
        return mutableLiveData ;
    }

}
