package com.example.waviq.iak.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.waviq.iak.R;
import com.example.waviq.iak.ui.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        WeatherFragment weatherFragment = (WeatherFragment) fragmentManager.findFragmentById(R.id.frame_main_activity);
//
//        if( weatherFragment == null){
//            weatherFragment = WeatherFragment.newInstance("","");
//            fragmentManager.beginTransaction().add(R.id.frame_main_activity, weatherFragment).commit();
//        }
        getSupportFragmentManager().beginTransaction().add(R.id.frame_main_activity, new WeatherFragment()).commit();

        //b334f5298510bfe690634cef74f08b8c
    }
}
