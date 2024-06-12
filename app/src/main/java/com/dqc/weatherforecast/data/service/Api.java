package com.dqc.weatherforecast.data.service;


import com.dqc.weatherforecast.data.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("api/weather/city/{cityCode}")
    Call<WeatherModel> queryWeather(@Path("cityCode") String cityCode);
}
