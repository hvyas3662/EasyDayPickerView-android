package com.easydaypicker_sample;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.elevationsoft.easydaypicker.DayPicker;
import com.elevationsoft.easydaypicker.OnDaySelectionChangeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DayPicker dp = findViewById(R.id.dp);
        dp.setDaysName(new String[]{"Sun", "Mon", "Tue", "Wed", "The", "Fri", "Sat"});
        dp.setDayBtnTextSize(10);
        dp.setDayBtnMarginPx(5, 5, 5, 5);
        dp.setDayBtnStateTextColors(Color.parseColor("#000000"), Color.parseColor("#ffffff"));
        dp.setSelectedDayIndex(1);
        dp.setDayBtnTextAppearance(this, R.style.easyDayPickerDefaultBtnStyle);
        dp.setDayBtnBackground(R.drawable.daybtnbackground_ring);
        dp.setMultipleSelected(true, false, false, true, false, false, true);

        dp.setOnDaySelectionChangeListener(new OnDaySelectionChangeListener() {
            @Override
            public void OnDaySelectionChange(ArrayList<Boolean> getSelectedDays, ArrayList<String> getSelectedDaysName, ArrayList<String> getSelectedDaysShortName) {
                Log.d("SelectedDays Array list", getSelectedDays.toString());
                Log.d("SelectedDays Name", getSelectedDaysName.toString());
                Log.d("SelectedDays Short Name", getSelectedDaysShortName.toString());
            }
        });

        Log.d("SelectedDays Array list", dp.getSelectedDays().toString());
        Log.d("Selected Days Name", dp.getSelectedDaysName().toString());
        Log.d("SelectedDays Short Name", dp.getSelectedDaysShortName().toString());
        Log.d("Nth child of view", dp.getNthChild(1).toString());

    }
}
