package com.dqc.weatherforecast.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dqc.weatherforecast.R;
import com.dqc.weatherforecast.data.model.WeatherModel;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherModel.ResultModel.FutureModel> weatherList;

    public WeatherAdapter(List<WeatherModel.ResultModel.FutureModel> weatherList) {
        this.weatherList = weatherList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherModel.ResultModel.FutureModel weatherItem = weatherList.get(position);
        holder.dayTextView.setText(weatherItem.getDate());
        holder.weatherTextView.setText(weatherItem.getWeather());
        holder.temperatureTextView.setText(weatherItem.getTemperature());
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        public TextView dayTextView;
        public TextView weatherTextView;
        public TextView temperatureTextView;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            dayTextView = itemView.findViewById(R.id.day_text);
            weatherTextView = itemView.findViewById(R.id.weather_text);
            temperatureTextView = itemView.findViewById(R.id.temperature_text);
        }
    }
}
