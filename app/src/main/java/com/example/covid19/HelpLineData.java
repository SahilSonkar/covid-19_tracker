package com.example.covid19;

import android.widget.TextView;

public class HelpLineData {

    public String stateNames;
    public String stateHelpLineNumbers;
    public boolean down;

    public HelpLineData(String stateNames, String stateHelpLineNumbers) {
        this.stateNames = stateNames;
        this.stateHelpLineNumbers = stateHelpLineNumbers;
        this.down=false;
    }

    public String getStateNames() {
        return stateNames;
    }

    public void setStateNames(String stateNames) {
        this.stateNames = stateNames;
    }

    public String getStateHelpLineNumbers() {
        return stateHelpLineNumbers;
    }

    public void setStateHelpLineNumbers(String stateHelpLineNumbers) {
        this.stateHelpLineNumbers = stateHelpLineNumbers;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
