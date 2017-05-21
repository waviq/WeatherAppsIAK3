package com.example.waviq.iak.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waviq.iak.R;
import com.example.waviq.iak.models.WeatherModel;

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

        time.setText("200");



        return  v;



    }
}
