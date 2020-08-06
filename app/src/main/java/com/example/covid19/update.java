package com.example.covid19;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.Stats.Post;
import com.example.covid19.Stats.data;
import com.example.covid19.Stats.preData;
import com.example.covid19.Stats.recyclerView;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class update extends Fragment {
    private static final String TAG = "update";

    private RecyclerView mRecyclerView;
    public ArrayList<data> arrayList=new ArrayList<>();
    public ProgressBar progressBar;
    private sendData sendData;
    private TextView ToalCaseAcrossIndia;
    private TextView TotalAvtiveCaseAcrossIndia;
    private TextView TotalRecoverCasesAcrosIndia;
    private TextView ToatalDeathCasesAcrossIndia;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            sendData=(sendData)getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException("Error");
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.update, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);


        ToalCaseAcrossIndia=view.findViewById(R.id.AcrossIndiaTotal);
        TotalAvtiveCaseAcrossIndia=view.findViewById(R.id.ActiveNumberAcroosIndia);
        TotalRecoverCasesAcrosIndia=view.findViewById(R.id.RecoverNumberAcroosIndia);
        ToatalDeathCasesAcrossIndia=view.findViewById(R.id.DeathNumberAcroosIndia);

        progressBar=view.findViewById(R.id.progresUpdate);
        SetUpdates();
        progressBar.setVisibility(View.INVISIBLE);

        
        return view;
    }
    public void SetUpdates() {

        progressBar.setVisibility(View.VISIBLE);
        String BASE_URL = "http://api.covid19india.org/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Post post = retrofit.create(Post.class);
        Call<preData> call = post.getpreData();
        call.enqueue(new Callback<preData>() {
            @Override
            public void onResponse(Call<preData> call, Response<preData> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                arrayList = response.body().getArrayList();
                sendData.send(arrayList);
                recyclerView recyclerView = new recyclerView(arrayList, getContext());
                mRecyclerView.setAdapter(recyclerView);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                Log.d(TAG, "onResponse: "+arrayList.size()+"complete---------------------------------------------------------------------------");
                filled(arrayList);
                
            }
            @Override
            public void onFailure(Call<preData> call, Throwable t) {
            }
        });
    }

    public interface sendData{
        public void send(ArrayList<data> arrayList);
    }
    public void filled(ArrayList<data> marrayList)
    {
        TotalAvtiveCaseAcrossIndia.setText(String.valueOf(marrayList.get(0).getActive()));
        TotalRecoverCasesAcrosIndia.setText(String.valueOf(marrayList.get(0).getRecoverd()));
        ToatalDeathCasesAcrossIndia.setText(String.valueOf(marrayList.get(0).getDeath()));
    }
}
