package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;


import com.example.covid19.Stats.Post;
import com.example.covid19.Stats.data;
import com.example.covid19.Stats.preData;
import com.example.covid19.Stats.recyclerView;
import com.google.android.material.tabs.TabLayout;

import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements update.sendData{

    private static final String TAG = "MainActivity";

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String messege;
    private ArrayList<data> arrayList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        //SetUpdates();

        toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);
        viewPager = findViewById(R.id.viewpager);
        setFragment(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        detectPageChange(viewPager);

    }

    public void setFragment(ViewPager viewPager)
    {
        TablayoutAdapter tablayoutAdapter=new TablayoutAdapter(getSupportFragmentManager());
        tablayoutAdapter.add(new home(),"home");
        tablayoutAdapter.add(new update(),"Update");
        tablayoutAdapter.add(new Graph(),"HelpLines");

        viewPager.setAdapter(tablayoutAdapter);
    }
    public void detectPageChange(ViewPager mViewPager)
    {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Log.d(TAG, "onPageSelected: "+String.valueOf(position)+messege);
//                if(position==2){
//                    String tag = "android:switcher:" + R.id.viewpager + ":" + 2;
//                    Graph graph= (Graph) getSupportFragmentManager().findFragmentByTag(tag);
//                    graph.display(arrayList);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    public void send(ArrayList<data> mArrayList) {
        if(mArrayList!=null)
        arrayList=mArrayList;
        else
            Log.d(TAG, "send: NULL");
    }
}
