package com.hvyas.easydaypicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class DayPicker extends LinearLayout {
    ToggleButton days[] = new ToggleButton[7];
    String days_name[] = {"S", "M", "T", "W", "T", "F", "S"};
    int SelectedDay;
    int DayBtnTextAppearance;
    int DayBtnBackground;
    int DayBtnMargin, DayBtnMarginLeft, DayBtnMarginTop, DayBtnMarginBottom, DayBtnMarginRight;
    int DayBtnSelectedTextColor, DayBtnUnSelectedTextColor;
    int DayBtnTextSize;
    OnDaySelectionChangeListener listener;
    ArrayList<Boolean> result = new ArrayList<>();

    public DayPicker(Context context) {
        this(context, null);
    }

    public DayPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DayPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DayPicker, 0, 0);
        SelectedDay = a.getInteger(R.styleable.DayPicker_SelectedDay, -1);
        DayBtnTextAppearance = a.getResourceId(R.styleable.DayPicker_DayBtnTextAppearance, R.style.easyDayPickerDefaultBtnStyle);
        DayBtnBackground = a.getResourceId(R.styleable.DayPicker_DayBtnBackground, R.drawable.daybtnbackground_round);
        DayBtnMarginLeft = a.getDimensionPixelSize(R.styleable.DayPicker_DayBtnMarginLeft, 0);
        DayBtnMarginTop = a.getDimensionPixelSize(R.styleable.DayPicker_DayBtnMarginTop, 0);
        DayBtnMarginRight = a.getDimensionPixelSize(R.styleable.DayPicker_DayBtnMarginRight, 0);
        DayBtnMarginBottom = a.getDimensionPixelSize(R.styleable.DayPicker_DayBtnMarginBottom, 0);
        DayBtnMargin = a.getDimensionPixelSize(R.styleable.DayPicker_DayBtnMargin, -1);
        DayBtnSelectedTextColor = a.getColor(R.styleable.DayPicker_DayBtnSelectedTextColor, Color.WHITE);
        DayBtnUnSelectedTextColor = a.getColor(R.styleable.DayPicker_DayBtnUnSelectedTextColor, Color.BLACK);
        DayBtnTextSize = a.getDimensionPixelSize(R.styleable.DayPicker_DayBtnTextSize, 20);
        a.recycle();
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        removeAllViews();
        for (int i = 0; i < 7; i++) {
            days[i] = new ToggleButton(context);
            days[i].setTextAppearance(context, DayBtnTextAppearance);
            days[i].setTextSize(DayBtnTextSize);
            days[i].setText(days_name[i]);
            days[i].setTextOff(days_name[i]);
            days[i].setTextOn(days_name[i]);
            days[i].setBackgroundResource(DayBtnBackground);
            days[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        buttonView.setTextColor(DayBtnSelectedTextColor);
                    } else {
                        buttonView.setTextColor(DayBtnUnSelectedTextColor);
                    }

                    if (listener != null) {
                        listener.OnDaySelectionChange(getSelectedDays(), getSelectedDaysName(), getSelectedDaysShortName());
                    }

                }
            });
            LinearLayout.LayoutParams tbp = new LinearLayout.LayoutParams(140, 140);
            if (DayBtnMargin == -1) {
                tbp.setMargins(DayBtnMarginLeft, DayBtnMarginTop, DayBtnMarginRight, DayBtnMarginBottom);
            } else {
                tbp.setMargins(DayBtnMargin, DayBtnMargin, DayBtnMargin, DayBtnMargin);
            }
            days[i].setLayoutParams(tbp);
            addView(days[i]);
            if (SelectedDay == i) {
                days[SelectedDay].setChecked(true);
            }


            if (days[i].isChecked()) {
                days[i].setTextColor(DayBtnSelectedTextColor);
            } else {
                days[i].setTextColor(DayBtnUnSelectedTextColor);
            }

        }


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        for (int i = 0; i < 7; i++) {
            LinearLayout.LayoutParams tbp = new LinearLayout.LayoutParams(getWidth() / 8, getWidth() / 8);
            if (DayBtnMargin == -1) {
                tbp.setMargins(DayBtnMarginLeft, DayBtnMarginTop, DayBtnMarginRight, DayBtnMarginBottom);
            } else {
                tbp.setMargins(DayBtnMargin, DayBtnMargin, DayBtnMargin, DayBtnMargin);
            }

            days[i].setLayoutParams(tbp);
        }
    }


    // getter and setter
    public void setOnDaySelectionChangeListener(OnDaySelectionChangeListener listener) {
        this.listener = listener;
    }

    public void setDaysName(String[] days_name) {
        this.days_name = days_name;
        for (int i = 0; i < 7; i++) {
            days[i].setTextOff(days_name[i]);
            days[i].setTextOn(days_name[i]);
        }

    }

    public String[] getDaysName() {
        return days_name;
    }

    public void setSelectedDayIndex(int index) {
        if (index >= 7) {
            SelectedDay = -1;
        } else {
            SelectedDay = index;
        }
        if (SelectedDay >= 0) {
            days[SelectedDay].setChecked(true);
        }

    }

    public void setDayBtnTextAppearance(Context ctx, int id) {
        DayBtnTextAppearance = id;
        for (int i = 0; i < 7; i++) {
            days[i].setTextAppearance(ctx, DayBtnTextAppearance);
        }
    }

    public int getDayBtnTextAppearance() {
        return DayBtnTextAppearance;
    }

    public void setDayBtnBackground(int id) {
        DayBtnBackground = id;
        for (int i = 0; i < 7; i++) {
            days[i].setBackgroundResource(DayBtnBackground);
        }
    }

    public int getDayBtnBackground() {
        return DayBtnBackground;
    }

    public void setDayBtnMarginPx(int left, int top, int right, int bottom) {
        if (left == top && left == right && left == bottom) {
            DayBtnMargin = left;
        } else {
            DayBtnMargin = -1;
        }
        DayBtnMarginLeft = left;
        DayBtnMarginTop = top;
        DayBtnMarginRight = right;
        DayBtnMarginBottom = bottom;

        requestLayout();
    }

    public int getDayBtnMarginLeftPx() {
        return DayBtnMarginLeft;
    }

    public int getDayBtnMarginTopPx() {
        return DayBtnMarginTop;
    }

    public int getDayBtnMarginRightPx() {
        return DayBtnMarginRight;
    }

    public int getDayBtnMarginBottomPx() {
        return DayBtnMarginBottom;
    }

    public int getDayBtnSelectedTextColor() {
        return DayBtnSelectedTextColor;
    }

    public int getDayBtnUnSelectedTextColor() {
        return DayBtnUnSelectedTextColor;
    }

    public void setDayBtnStateTextColors(int DayBtnSelectedTextColor, int DayBtnUnSelectedTextColor) {
        this.DayBtnSelectedTextColor = DayBtnSelectedTextColor;
        this.DayBtnUnSelectedTextColor = DayBtnUnSelectedTextColor;
        for (int i = 0; i < 7; i++) {
            if (days[i].isChecked()) {
                days[i].setTextColor(DayBtnSelectedTextColor);
            } else {
                days[i].setTextColor(DayBtnUnSelectedTextColor);
            }
        }
    }

    public int getDayBtnTextSize() {
        return DayBtnTextSize;
    }

    public void setDayBtnTextSize(int dayBtnTextSize) {
        DayBtnTextSize = dayBtnTextSize;
        for (int i = 0; i < 7; i++) {
            days[i].setTextSize(DayBtnTextSize);
        }
    }

    public void setMultipleSelected(boolean status_sun, boolean status_mon, boolean status_tue, boolean status_wed, boolean status_thu, boolean status_fri, boolean status_sat) {
        days[0].setChecked(status_sun);
        days[1].setChecked(status_mon);
        days[2].setChecked(status_tue);
        days[3].setChecked(status_wed);
        days[4].setChecked(status_thu);
        days[5].setChecked(status_fri);
        days[6].setChecked(status_sat);
    }


    // output
    public ArrayList<Boolean> getSelectedDays() {
        result.clear();
        for (int i = 0; i < 7; i++) {
            result.add(days[i].isChecked());
        }
        return result;
    }

    public ArrayList<String> getSelectedDaysName() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (days[i].isChecked()) {
                switch (i) {
                    case 0:
                        result.add("sunday");
                        break;
                    case 1:
                        result.add("monday");
                        break;
                    case 2:
                        result.add("tuesday");
                        break;
                    case 3:
                        result.add("wednesday");
                        break;
                    case 4:
                        result.add("thursday");
                        break;
                    case 5:
                        result.add("friday");
                        break;
                    case 6:
                        result.add("saturday");
                        break;
                }
            }
        }
        return result;
    }

    public ArrayList<String> getSelectedDaysShortName() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (days[i].isChecked()) {
                switch (i) {
                    case 0:
                        result.add("sun");
                        break;
                    case 1:
                        result.add("mon");
                        break;
                    case 2:
                        result.add("tue");
                        break;
                    case 3:
                        result.add("wed");
                        break;
                    case 4:
                        result.add("thu");
                        break;
                    case 5:
                        result.add("fri");
                        break;
                    case 6:
                        result.add("sat");
                        break;
                }
            }
        }
        return result;
    }

    public ToggleButton getNthChild(int index) {
        if (index >= 7) {
            return null;
        }
        return days[index];
    }

}
