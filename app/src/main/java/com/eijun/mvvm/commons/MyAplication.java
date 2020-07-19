package com.eijun.mvvm.commons;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MyAplication extends Application {

    final String TAG = getClass().getSimpleName() ;
    private static MyAplication mInstance ;
    private static Retrofit retrofit =  null ;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this ;
    }

    public static  synchronized MyAplication getInstance(){
        return mInstance ;
    }

    public boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = null ;

        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        return networkInfo!= null && networkInfo.isConnected() ;
    }

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder().build() ;

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constans.base_url)
                    .build();
        }
        return retrofit;
    }
}
