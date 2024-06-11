package com.dqc.weatherforecast.data.service;


import com.dqc.weatherforecast.data.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("simpleWeather/query")
    Call<WeatherModel> queryWeather(@Query("city") String city);
}
