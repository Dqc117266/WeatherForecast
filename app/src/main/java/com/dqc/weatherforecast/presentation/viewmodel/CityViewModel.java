package com.dqc.weatherforecast.presentation.viewmodel;

// CityViewModel.java
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dqc.weatherforecast.data.model.CityModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CityViewModel extends AndroidViewModel {

    private MutableLiveData<List<CityModel>> cityListLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> closeActivityLiveData = new MutableLiveData<>();
    public static final String PREFS_NAME = "selected_city_prefs";
    public static final String SELECTED_CITY_KEY = "selected_city";

    public CityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<CityModel>> getCityListLiveData() {
        return cityListLiveData;
    }

    public MutableLiveData<Boolean> getCloseActivityLiveData() {
        return closeActivityLiveData;
    }

    public void loadCityData() {
        try {
            InputStream is = getApplication().getAssets().open("new_city.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            Type listType = new TypeToken<List<CityModel>>(){}.getType();
            List<CityModel> cityList = gson.fromJson(json, listType);
            List<CityModel> filteredCityList = new ArrayList<>();
            for (CityModel city : cityList) {
                if (city.getCity_code() != null && !city.getCity_code().trim().isEmpty()) {
                    filteredCityList.add(city);
                }
            }
            cityListLiveData.postValue(filteredCityList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void onCitySelected(CityModel city) {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SELECTED_CITY_KEY, city.getCity_code());
        editor.apply();

        Toast.makeText(getApplication(), "已选择城市: " + city.getCity_name(), Toast.LENGTH_SHORT).show();

        closeActivityLiveData.postValue(true);
    }
}

