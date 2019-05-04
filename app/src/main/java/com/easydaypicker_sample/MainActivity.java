package com.easydaypicker_sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hvyas.easydaypicker.DayPicker;
import com.hvyas.easydaypicker.OnDaySelectionChangeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DayPicker dp;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.dp);
        dp.setDaysName(new String[]{"a", "b", "c", "d", "f", "g", "h"});
        dp.setDayBtnTextSize(15);
        dp.setDayBtnMarginPx(5, 5, 5, 5);
        dp.setDayBtnStateTextColors(Color.parseColor("#ffffff"), Color.parseColor("#000000"));
        dp.setSelectedDayIndex(1);
        dp.setDayBtnTextAppearance(this, R.style.easyDatePickerDefaultBtnStyle2);
        dp.setDayBtnBackground(R.drawable.toggle_back);
        dp.setMultipleSelected(true, false, false, true, false, false, true);
        dp.setOnDaySelectionChangeListener(new OnDaySelectionChangeListener() {
            @Override
            public void OnDaySelectionChange(ArrayList<Boolean> getSelectedDays, ArrayList<String> getSelectedDaysName, ArrayList<String> getSelectedDaysShortName) {
                Log.d("data", getSelectedDays.toString());
                Log.d("data", getSelectedDaysName.toString());
                Log.d("data", getSelectedDaysShortName.toString());
            }
        });


        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, dp.getSelectedDays().toString()+"\n"+dp.getSelectedDaysName().toString()+"\n"+dp.getSelectedDaysShortName().toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
