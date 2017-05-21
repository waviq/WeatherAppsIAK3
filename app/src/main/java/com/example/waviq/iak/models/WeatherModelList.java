package com.example.waviq.iak.models;

/**
 * Created by Admin on 21/05/2017.
 */

public class WeatherModelList {

    private String time;
    private String status;
    private double tempMax;
    private double tempMin;

    public WeatherModelList(String time, String status, double tempMax, double tempMin) {
        this.time = time;
        this.status = status;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }
}
