package com.dqc.weatherforecast.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dqc.weatherforecast.data.model.WeatherModel;
import com.dqc.weatherforecast.data.repository.WeatherRepositoryImpl;

public class WeatherViewModel extends ViewModel {

    private WeatherRepositoryImpl weatherRepository;
    private LiveData<WeatherModel> weatherLiveData;

    public WeatherViewModel() {
        weatherRepository = new WeatherRepositoryImpl();
        weatherLiveData = weatherRepository.getWeatherLiveData();
    }

    public LiveData<WeatherModel> getWeatherLiveData() {
        return weatherLiveData;
    }

    public void fetchWeather(String city) {
        weatherRepository.fetchWeather(city);
    }
}

