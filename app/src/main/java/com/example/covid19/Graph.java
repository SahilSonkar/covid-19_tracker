package com.example.covid19;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.Stats.data;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class Graph extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<HelpLineData> arrayList;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    private static final String TAG = "Graph";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.graph, container, false);

        arrayList=new ArrayList<>();
        initialiseArrayList();

        recyclerView=view.findViewById(R.id.recyclerViewforHelLineNumber);
        RecyclerViewNumber recyclerViewNumber=new RecyclerViewNumber(arrayList,getContext());
        recyclerView.setAdapter(recyclerViewNumber);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }



    private void initialiseArrayList() {


        arrayList.add(new HelpLineData("Andhra Pradesh","+91-866-2410978"));
        arrayList.add(new HelpLineData("Arunachal Pradesh","+91-9436055743"));
        arrayList.add(new HelpLineData("Assam","+91-6913347770"));
        arrayList.add(new HelpLineData("Bihar","104"));
        arrayList.add(new HelpLineData("Chhattisgarh","104"));
        arrayList.add(new HelpLineData("Goa","104"));
        arrayList.add(new HelpLineData("Gujarat","104"));
        arrayList.add(new HelpLineData("Haryana","+91-8558893911"));
        arrayList.add(new HelpLineData("Himachal Pradesh","104"));
        arrayList.add(new HelpLineData("Jharkhand","104"));
        arrayList.add(new HelpLineData("Andhra Pradesh","+91-866-2410978"));
        arrayList.add(new HelpLineData("Andhra Pradesh","+91-866-2410978"));
        arrayList.add(new HelpLineData("Andhra Pradesh","+91-866-2410978"));
        arrayList.add(new HelpLineData("Andhra Pradesh","+91-866-2410978"));


    }
}
