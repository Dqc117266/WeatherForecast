package com.dqc.weatherforecast.presentation.activity;

import static com.dqc.weatherforecast.presentation.utils.StatusBarUtil.getStatusBarHeight;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dqc.weatherforecast.R;
import com.dqc.weatherforecast.data.model.CityModel;
import com.dqc.weatherforecast.presentation.adapter.CityAdapter;
import com.dqc.weatherforecast.presentation.viewmodel.CityViewModel;

import java.util.ArrayList;
import java.util.List;

public class CityManagerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CityViewModel cityViewModel;
    private CityAdapter adapter;
    private EditText searchCity;
    private List<CityModel> cityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this, SystemBarStyle.dark(Color.TRANSPARENT), SystemBarStyle.dark(Color.TRANSPARENT));

        setContentView(R.layout.activity_city_manager);
        initViews();
    }

    public void initViews() {
        int statusBarHeight = getStatusBarHeight(this);

        // 获取 MaterialToolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> finish());

        // 设置 MaterialToolbar 的 marginTop 属性为状态栏的高度
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) toolbar.getLayoutParams();
        params.setMargins(0, statusBarHeight, 0, 0);
        toolbar.setLayoutParams(params);

        searchCity = findViewById(R.id.search_city);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cityViewModel = new ViewModelProvider(this).get(CityViewModel.class);

        cityViewModel.getCityListLiveData().observe(this, new Observer<List<CityModel>>() {
            @Override
            public void onChanged(List<CityModel> cityModels) {
                cityList = cityModels;
                adapter = new CityAdapter(cityModels, cityViewModel::onCitySelected);
                recyclerView.setAdapter(adapter);
            }
        });

        cityViewModel.getCloseActivityLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean shouldClose) {
                if (shouldClose) {
                    finish();
                }
            }
        });

        cityViewModel.loadCityData();

        searchCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        List<CityModel> filteredList = new ArrayList<>();
        for (CityModel city : cityList) {
            if (city.getCity_name().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(city);
            }
        }
        adapter.filterList(filteredList);
    }
}
