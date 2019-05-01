package com.hvyas.easydaypicker;

import java.util.ArrayList;

public interface OnDaySelectionChangeListener {
    void OnDaySelectionChange(ArrayList<Boolean> getSelectedDays, ArrayList<String> getSelectedDaysName, ArrayList<String> getSelectedDaysShortName);
}
