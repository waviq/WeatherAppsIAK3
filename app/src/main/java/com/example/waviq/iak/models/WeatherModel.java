package com.example.waviq.iak.models;

import android.icu.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Waviq on 5/21/17.
 */

public class WeatherModel {

    private String time;
    private String dayDate;
    private int maxTemp;
    private int minTemp;
    private String status;
    private String city;
    private String country;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {

        SimpleDateFormat formatDefault = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat formatTimeCustom = new SimpleDateFormat("hh.mm");

        try {
            Date timesFormat = formatDefault.parse(time);
            time = formatTimeCustom.format(timesFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.time = time;
    }

    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
