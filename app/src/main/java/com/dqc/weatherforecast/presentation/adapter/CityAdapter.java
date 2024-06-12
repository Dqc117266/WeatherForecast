package com.dqc.weatherforecast.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dqc.weatherforecast.R;
import com.dqc.weatherforecast.data.model.CityModel;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private List<CityModel> cityList;
    private OnCityClickListener onCityClickListener;

    public interface OnCityClickListener {
        void onCityClick(CityModel city);
    }

    public CityAdapter(List<CityModel> cityList, OnCityClickListener onCityClickListener) {
        this.cityList = cityList;
        this.onCityClickListener = onCityClickListener;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        CityModel city = cityList.get(position);
        holder.cityName.setText(city.getCity_name());
        holder.itemView.setOnClickListener(v -> onCityClickListener.onCityClick(city));
    }

    public void filterList(List<CityModel> filteredList) {
        cityList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    static class CityViewHolder extends RecyclerView.ViewHolder {
        TextView cityName;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.city_name);
        }
    }
}