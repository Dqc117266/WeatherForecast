package com.dqc.weatherforecast.presentation.activity;

import static com.dqc.weatherforecast.presentation.utils.StatusBarUtil.getStatusBarHeight;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dqc.weatherforecast.R;
import com.dqc.weatherforecast.data.model.WeatherModel;
import com.dqc.weatherforecast.presentation.viewmodel.WeatherViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this, SystemBarStyle.dark(Color.TRANSPARENT), SystemBarStyle.dark(Color.TRANSPARENT));

        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        int statusBarHeight = getStatusBarHeight(this);

        // 获取 MaterialToolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 设置 MaterialToolbar 的 marginTop 属性为状态栏的高度
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) toolbar.getLayoutParams();
        params.setMargins(0, statusBarHeight, 0, 0);
        toolbar.setLayoutParams(params);

        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

//        weatherViewModel.fetchWeather("北京");

        weatherViewModel.getWeatherLiveData().observe(this, new Observer<WeatherModel>() {
            @Override
            public void onChanged(WeatherModel weatherModel) {
                if (weatherModel != null) {
                    List<WeatherModel.ResultModel.FutureModel> weatherList = weatherModel.getResult().getFuture();

                    for (int i = 0; i < weatherList.size(); i++) {
                        WeatherModel.ResultModel.FutureModel futureModel = weatherList.get(i);
                        System.out.println("futureModel:" + futureModel.getTemperature());
                    }
//                    System.out.println("weatherList:" + weatherList);
//                    weatherAdapter = new WeatherAdapter(weatherList);
//                    recyclerView.setAdapter(weatherAdapter);
                }
            }
        });
    }
}