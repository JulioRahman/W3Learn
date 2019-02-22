package com.w3learnteam.w3learn.learn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.w3learnteam.w3learn.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Hsub_Adapter extends RecyclerView.Adapter<Hsub_Adapter.HsubHolder> {

    private ArrayList<HSub> hSubs;

    public Hsub_Adapter(ArrayList<HSub> hSubs){
        this.hSubs = hSubs;
    }

    @NonNull
    @Override
    public HsubHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.hsub_item,parent,false);
        return new Hsub_Adapter.HsubHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HsubHolder holder, int position) {
        holder.titlehsub.setText(hSubs.get(position).getHsubitem());
        holder.deschsub.setText(hSubs.get(position).getHsubdesc());
    }

    @Override
    public int getItemCount() {
        return (hSubs != null) ? hSubs.size() : 0;
    }



    public class HsubHolder extends RecyclerView.ViewHolder {

        private TextView titlehsub,deschsub;

        public HsubHolder(@NonNull View itemView) {
            super(itemView);
            titlehsub = (TextView) itemView.findViewById(R.id.hsubitem);
            deschsub = (TextView) itemView.findViewById(R.id.hdescitem);
        }
    }
}
