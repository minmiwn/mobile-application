package vn.edu.usth.weatherapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (savedInstanceState == null) {
            // 1. Tạo và add WeatherFragment vào phần chứa ở trên
            WeatherFragment weatherFragment = new WeatherFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.weather_container, weatherFragment)
                    .commit();

            // 2. Tạo và add ForecastFragment vào phần chứa ở dưới
            ForecastFragment forecastFragment = new ForecastFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.forecast_container, forecastFragment)
                    .commit();
        }

        Log.i(TAG, "===== App Created ===");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "----- App Started -----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "@@@@@ App Resumed @@@@@");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "+++++ App Paused +++++");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "##### App Destroyed #####");
    }
}