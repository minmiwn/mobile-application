package vn.edu.usth.weatherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";

    // 1. Khai báo biến MediaPlayer
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // 2. Khởi tạo và phát nhạc từ file res/raw/farout.mp3
        mp = MediaPlayer.create(this, R.raw.farout);
        if (mp != null) {
            mp.start();
        }

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

        // 3. Giải phóng tài nguyên nhạc khi tắt ứng dụng
        if (mp != null) {
            mp.release();
            mp = null;
        }

        Log.i(TAG, "##### App Destroyed #####");
    }
}