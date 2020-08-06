package com.example.covid19.Stats;

import com.google.gson.annotations.SerializedName;

public class data {

    @SerializedName("active")
    public int active;

    @SerializedName("confirmed")
    public int confirmed;

    @SerializedName("deaths")
    public int death;

    @SerializedName("recovered")
    public int recoverd;

    @SerializedName("state")
    public String stateName;

    @SerializedName("statecode")
    public String StateCode;

    public String getLastUpdateTime() {
        return LastUpdateTime;
    }

    @SerializedName("lastupdatedtime")
    public String LastUpdateTime;

    public int getActive() {
        return active;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeath() {
        return death;
    }

    public int getRecoverd() {
        return recoverd;
    }

    public String getStateName() {
        return stateName;
    }

    public String getStateCode() {
        return StateCode;
    }
}
