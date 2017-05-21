package com.example.waviq.iak.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.waviq.iak.R;
import com.example.waviq.iak.adapters.WeatherAdapter;
import com.example.waviq.iak.config.Constant;
import com.example.waviq.iak.models.WeatherModel;
import com.example.waviq.iak.models.WeatherModelList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeatherFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private WeatherModel weatherModel = new WeatherModel();


    @BindView(R.id.tvTime)TextView time;
    @BindView(R.id.imgLogoUtama)ImageView logoUtana;
    @BindView(R.id.tvDayDate)TextView dayDate;
    @BindView(R.id.imgCuaca)ImageView cuacaLogo;
    @BindView(R.id.tvMaxTemp)TextView maxTemp;
    @BindView(R.id.tvMinTemp)TextView minTemp;
    @BindView(R.id.tvStatus)TextView status;
    @BindView(R.id.tvCity)TextView city;

    /*private TextView time;
    private ImageView logoUtana;
    private TextView dayDate;
    private ImageView cuacaLogo;
    private TextView maxTemp;
    private TextView minTemp;
    private TextView status;
    private TextView city;*/

    private ArrayList<WeatherModelList> mWeatherModelList = new ArrayList<>();

    WeatherAdapter adapterWeather;




    public WeatherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeatherFragment newInstance(String param1, String param2) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_weather, container, false);

        ButterKnife.bind(this, v);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycleList);
        adapterWeather = new WeatherAdapter(mWeatherModelList);
        recyclerView.setAdapter(adapterWeather);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Constant.fullUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject cityObject = response.getJSONObject("city");
                    String nameCity = cityObject.getString("name");
                    JSONArray list = response.getJSONArray("list");
                    JSONObject jsonIndex = list.getJSONObject(0);

                    String times = jsonIndex.getString("dt_txt");



                    Log.d("List...", list.toString());

                    weatherModel.setCity(nameCity);
                    weatherModel.setTime(times);

                    city.setText(weatherModel.getCity());
                    time.setText(weatherModel.getTime());

                    for(int x=0;x<10;x++){

                        JSONObject object = list.getJSONObject(x);
                        JSONObject main = object.getJSONObject("main");
                        Double maxTempList = main.getDouble("temp_max");
                        Double minTempList = main.getDouble("temp_min");


                        JSONArray weatherArrayList = object.getJSONArray("weather");
                        JSONObject weatherList = weatherArrayList.getJSONObject(0);
                        String weatherStatusList = weatherList.getString("main");

                        String dateMonthList = object.getString("dt_txt");

                        WeatherModelList weatherModelList = new WeatherModelList(dateMonthList,weatherStatusList,maxTempList,minTempList);
                        mWeatherModelList.add(weatherModelList);
                        adapterWeather.notifyDataSetChanged();

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error ",error.getLocalizedMessage());
            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);
        // Inflate the layout for this fragment
        return v;



    }
}
