package com.example.covid19.Stats;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.R;

import java.util.ArrayList;

public class recyclerView extends RecyclerView.Adapter<recyclerView.viewHolder> {

    private static final String TAG = "recyclerView";
    private ArrayList<data> arrayList;
    private Context context;
    private int c=0;
    public recyclerView(ArrayList<data> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // Log.d(TAG, "onCreateViewHolder: "+String.valueOf(c));
        c++;
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        if(position+1!=arrayList.size()) {
            holder.stateName.setText(arrayList.get(position + 1).getStateName());
            holder.active.setText(String.valueOf(arrayList.get(position + 1).getActive()));
            holder.death.setText(String.valueOf(arrayList.get(position + 1).getDeath()));
            holder.recover.setText(String.valueOf(arrayList.get(position + 1).getRecoverd()));
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView stateName,active,death,recover;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            stateName=itemView.findViewById(R.id.stateName);
            active=itemView.findViewById(R.id.activeNumber);
            death=itemView.findViewById(R.id.deathNumber);
            recover=itemView.findViewById(R.id.recoveryNumber);
        }
    }
}
