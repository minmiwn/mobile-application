package vn.edu.usth.weatherapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForecastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 1. Create icon
        TextView day = new TextView(getContext());
        day.setText("Thursday");

        ImageView img = new ImageView(getContext());
        img.setImageResource(R.drawable.maincloudy);
        img.setBackgroundColor(Color.parseColor("#aac7f0"));

        // 2. Create background color
        // Way 1
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
        v.setBackgroundColor(Color.parseColor("#aac7f0"));

        // Way 2 : dynamic
        LinearLayout view = new LinearLayout(getContext());
        view.setOrientation(LinearLayout.VERTICAL);

        view.addView(day);
        view.addView(img);

        // return inflater.inflate(R.layout.fragment_forecast, container, false);
        return view;
    }
}