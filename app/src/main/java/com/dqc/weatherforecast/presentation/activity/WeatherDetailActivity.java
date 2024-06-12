package com.dqc.weatherforecast.presentation.activity;

import static com.dqc.weatherforecast.presentation.utils.StatusBarUtil.getStatusBarHeight;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dqc.weatherforecast.R;
import com.dqc.weatherforecast.data.model.WeatherModel;

public class WeatherDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather_detail);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("forecast_model")) {
            WeatherModel.DataModel.ForecastModel forecastModel = (WeatherModel.DataModel.ForecastModel) intent.getSerializableExtra("forecast_model");
            // 使用传递的数据进行操作

            System.out.println(" forecastModel " + forecastModel.getYmd());
            initViews(forecastModel);
        }

    }


    private void initViews(WeatherModel.DataModel.ForecastModel forecastModel) {
        int statusBarHeight = getStatusBarHeight(this);

        // 获取 MaterialToolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(forecastModel.getYmd());
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> finish());

        // 设置 MaterialToolbar 的 marginTop 属性为状态栏的高度
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) toolbar.getLayoutParams();
        params.setMargins(0, statusBarHeight, 0, 0);
        toolbar.setLayoutParams(params);
    }

}