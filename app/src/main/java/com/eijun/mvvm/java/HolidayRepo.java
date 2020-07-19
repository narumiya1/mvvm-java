package com.eijun.mvvm.java;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.eijun.mvvm.commons.ApiInteface;
import com.eijun.mvvm.commons.MyAplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayRepo {

    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<List<HolidayModel>> requestHoliday() {
        final MutableLiveData<List<HolidayModel>> mutableLiveData  = new MutableLiveData<>();

        ApiInteface apiInteface = MyAplication.getRetrofitClient().create(ApiInteface.class) ;
        apiInteface.getHolidays().enqueue(new Callback<List<HolidayModel>>() {
            @Override
            public void onResponse(Call<List<HolidayModel>> call, Response<List<HolidayModel>> response) {
                Log.e(TAG, "getCurrencyList response" +response);
                if (response.isSuccessful() && response.body() != null){
                    Log.e(TAG, "requestHolidays response.size="+response.body().size() );
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<HolidayModel>> call, Throwable t) {
                Log.e(TAG, "onFailure"+call.toString());


            }
        });

        return mutableLiveData ;
    }
}
