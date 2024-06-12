package com.dqc.weatherforecast.presentation.activity;

import static com.dqc.weatherforecast.presentation.viewmodel.CityViewModel.PREFS_NAME;
import static com.dqc.weatherforecast.presentation.viewmodel.CityViewModel.SELECTED_CITY_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.dqc.weatherforecast.R;
import com.dqc.weatherforecast.data.model.WeatherModel;
import com.dqc.weatherforecast.presentation.adapter.WeatherAdapter;
import com.dqc.weatherforecast.presentation.utils.StatusBarUtil;
import com.dqc.weatherforecast.presentation.utils.StringUtil;
import com.dqc.weatherforecast.presentation.viewmodel.WeatherViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements WeatherAdapter.OnItemClickListener {

    private WeatherViewModel weatherViewModel;
    private WeatherAdapter weatherAdapter;
    private TextView numberBigTextView;
    private TextView weatherTipsText;
    private TextView weatherText;
    private TextView temperatureNumberSmallText;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this, SystemBarStyle.dark(Color.TRANSPARENT), SystemBarStyle.dark(Color.TRANSPARENT));

        setContentView(R.layout.activity_main);
        initViews();
        setupRefreshLayout();
    }

    private void initViews() {
        int statusBarHeight = StatusBarUtil.getStatusBarHeight(this);
        int navigationBarHeight = StatusBarUtil.getNavigationBarHeight(this);

        // 获取 MaterialToolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);

        // 设置 MaterialToolbar 的 marginTop 属性为状态栏的高度
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) toolbar.getLayoutParams();
        params.setMargins(0, statusBarHeight, 0, 0);
        toolbar.setLayoutParams(params);

        ConstraintLayout.LayoutParams swipeRefreshLayoutLayoutParams = (ConstraintLayout.LayoutParams) swipeRefreshLayout.getLayoutParams();
        swipeRefreshLayoutLayoutParams.setMargins(0, 0, 0, navigationBarHeight);

        numberBigTextView = findViewById(R.id.temperature_number_big_text);
        weatherText = findViewById(R.id.weather_text);
        weatherTipsText = findViewById(R.id.weather_tips_text);
        temperatureNumberSmallText = findViewById(R.id.temperature_number_small_text);
        weatherTipsText.setSelected(true);

        recyclerView = findViewById(R.id.weather_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadSelectedCity();
    }

    private void loadSelectedCity() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String selectedCity = sharedPreferences.getString(SELECTED_CITY_KEY, "101010100");

        weatherViewModel.fetchWeather(selectedCity);

        weatherViewModel.getWeatherLiveData().observe(this, new Observer<WeatherModel>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(WeatherModel weatherModel) {
                if (weatherModel != null) {
                    numberBigTextView.setText(weatherModel.getData().getWendu());
                    weatherTipsText.setText(weatherModel.getData().getGanmao());
                    toolbar.setTitle(weatherModel.getCityInfo().getCity());

                    List<WeatherModel.DataModel.ForecastModel> weatherList = weatherModel.getData().getForecast();

                    weatherText.setText(weatherList.get(0).getType() + " " + weatherModel.getData().getQuality());

                    String lowNumber = StringUtil.extractTemperature(weatherList.get(0).getLow());
                    String highNumber = StringUtil.extractTemperature(weatherList.get(0).getHigh());

                    temperatureNumberSmallText.setText(lowNumber + " / " + highNumber + "°C");

                    weatherAdapter = new WeatherAdapter(weatherList);
                    weatherAdapter.setCurrentDateStr(weatherModel.getTime());
                    weatherAdapter.setListener(MainActivity.this);

                    recyclerView.setAdapter(weatherAdapter);
                }
            }
        });
    }

    private void setupRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                loadSelectedCity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_menu) {
            Intent intent = new Intent(this, CityManagerActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(WeatherModel.DataModel.ForecastModel forecastModel) {
        // 点击事件处理逻辑
        Intent intent = new Intent(MainActivity.this, WeatherDetailActivity.class);
        intent.putExtra("forecast_model", forecastModel);
        startActivity(intent);    }
}