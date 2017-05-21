package com.example.waviq.iak.adapters.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waviq.iak.R;
import com.example.waviq.iak.models.WeatherModelList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 21/05/2017.
 */

public class WeatherHolderList extends RecyclerView.ViewHolder {

    @BindView(R.id.iconMiniList)ImageView iconMini;
    @BindView(R.id.timeList)TextView timeList;
    @BindView(R.id.statusList) TextView statusList;
    @BindView(R.id.maxTempList)TextView tempMaxList;
    @BindView(R.id.minTempList)TextView tempMinList;

    public WeatherHolderList(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

    }

    public void updateUI(WeatherModelList weatherList){
        timeList.setText(weatherList.getTime());
        statusList.setText(weatherList.getStatus());
        tempMaxList.setText( String.valueOf(weatherList.getTempMax()));
        tempMinList.setText( String.valueOf(weatherList.getTempMin()));
    }

}
