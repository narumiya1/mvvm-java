package com.eijun.mvvm.commons;

import com.eijun.mvvm.java.HolidayModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInteface {

    @GET("PublicHolidays/2020/id")
    Call<List<HolidayModel>> getHolidays();

}
