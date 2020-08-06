package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewNumber extends RecyclerView.Adapter<RecyclerViewNumber.ViewHolder>{



    private ArrayList<HelpLineData> arrayList;
    private Context context;

    public RecyclerViewNumber(ArrayList<HelpLineData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_show, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.StateHelpLineNumber.setText(arrayList.get(position).getStateHelpLineNumbers().toString());
        holder.stateName.setText(arrayList.get(position).getStateNames().toString());
        boolean check=arrayList.get(position).isDown();
        holder.relativeLayout.setVisibility(check ? View.VISIBLE :View.GONE);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView stateName,StateHelpLineNumber;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            stateName=itemView.findViewById(R.id.stateNmaeNumber);
            StateHelpLineNumber=itemView.findViewById(R.id.statehelplineNumber);
            relativeLayout=itemView.findViewById(R.id.dropdown_number);
            stateName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HelpLineData helpLineData=arrayList.get(getAdapterPosition());
                    helpLineData.setDown(!helpLineData.isDown());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }


}

