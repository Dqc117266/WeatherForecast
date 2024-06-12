package com.dqc.weatherforecast.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dqc.weatherforecast.R;
import com.dqc.weatherforecast.data.model.WeatherModel;
import com.dqc.weatherforecast.presentation.utils.DateUtil;
import com.dqc.weatherforecast.presentation.utils.ImgUtil;
import com.dqc.weatherforecast.presentation.utils.StringUtil;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherModel.DataModel.ForecastModel> weatherList;
    private String currentDateStr;

    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public WeatherAdapter(List<WeatherModel.DataModel.ForecastModel> weatherList) {
        this.weatherList = weatherList;
    }

    public void setCurrentDateStr(String currentDateStr) {
        this.currentDateStr = currentDateStr;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherModel.DataModel.ForecastModel weatherItem = weatherList.get(position);

        String[] dateStrings = DateUtil.getFriendlyDateStrings(weatherItem.getYmd(), currentDateStr);

        holder.dayTextView.setText(dateStrings[0]);
        holder.monthTextView.setText(dateStrings[1]);
        holder.weatherTextView.setText(weatherItem.getType());

        String lowNumber = StringUtil.extractTemperature(weatherItem.getLow());
        String highNumber = StringUtil.extractTemperature(weatherItem.getHigh());
        holder.temperatureTextView.setText(lowNumber + " / " + highNumber + "°C");

        holder.weatherImageView.setImageResource(ImgUtil.getImgResOfWeather(weatherItem.getType()));

        holder.itemView.setOnClickListener(v -> {
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(weatherList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        public TextView dayTextView;
        public TextView monthTextView;
        public TextView weatherTextView;
        public TextView temperatureTextView;
        public ImageView weatherImageView;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            dayTextView = itemView.findViewById(R.id.day_text);
            monthTextView = itemView.findViewById(R.id.month_text);
            weatherTextView = itemView.findViewById(R.id.weather_text);
            temperatureTextView = itemView.findViewById(R.id.temperature_text);
            weatherImageView = itemView.findViewById(R.id.weather_image);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(WeatherModel.DataModel.ForecastModel forecastModel);
    }
}
