package com.example.covid19.Stats;

import com.example.covid19.Stats.data;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class preData {

    @SerializedName("statewise")
    public ArrayList<data> arrayList;

    public ArrayList<data> getArrayList() {
        return arrayList;
    }
}
