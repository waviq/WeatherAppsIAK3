package com.example.waviq.iak.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waviq.iak.R;
import com.example.waviq.iak.adapters.holders.WeatherHolderList;
import com.example.waviq.iak.models.WeatherModelList;

import java.util.ArrayList;

/**
 * Created by Admin on 21/05/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherHolderList> {

    private ArrayList<WeatherModelList>mWeatherModelList;

    public WeatherAdapter(ArrayList<WeatherModelList> mWeatherModelList) {
        this.mWeatherModelList = mWeatherModelList;
    }

    @Override
    public WeatherHolderList onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_weather_list, parent, false);
        return new WeatherHolderList(card);
    }

    //masukin data
    @Override
    public void onBindViewHolder(WeatherHolderList holder, int position) {
        WeatherModelList weatherModelList = mWeatherModelList.get(position);
        holder.updateUI(weatherModelList);
    }

    //berapa datanya
    @Override
    public int getItemCount() {
        return mWeatherModelList.size();
    }
}
