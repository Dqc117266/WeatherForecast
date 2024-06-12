package com.dqc.weatherforecast.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dqc.weatherforecast.data.model.WeatherModel;
import com.dqc.weatherforecast.data.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepositoryImpl {

    private MutableLiveData<WeatherModel> weatherLiveData = new MutableLiveData<>();

    public WeatherRepositoryImpl() {
    }

    public LiveData<WeatherModel> getWeatherLiveData() {
        return weatherLiveData;
    }

    public void fetchWeather(String city) {
        ApiService.getApi().queryWeather(city).enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    weatherLiveData.setValue(response.body());
                } else {
                    weatherLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                weatherLiveData.setValue(null);
            }
        });
    }
}

