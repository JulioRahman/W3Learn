package com.w3learnteam.w3learn.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.w3learnteam.w3learn.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CreatorsAdapter extends RecyclerView.Adapter<CreatorsAdapter.CreatorsViewHolder>{

    Context context;
    List<Creators> creatorsList;

    public CreatorsAdapter(Context context, List<Creators> creatorsList){
        this.context = context;
        this.creatorsList = creatorsList;
    }
    @NonNull
    @Override
    public CreatorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.creators_item, null);
        return new CreatorsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreatorsViewHolder holder, int position) {
        Creators event = creatorsList.get(position);

        holder.creatorname.setText(event.getCreatorname());
        holder.creatorjob.setText(event.getCreatorjob());
        holder.creatorpic.setImageDrawable(context.getResources().
                getDrawable(event.getCreatorpic()));

    }

    @Override
    public int getItemCount() {
        return creatorsList.size();
    }

    class CreatorsViewHolder extends RecyclerView.ViewHolder{

        TextView creatorname, creatorjob;
        ImageView creatorpic;

        public CreatorsViewHolder(@NonNull View itemView) {
            super(itemView);

            creatorname = itemView.findViewById(R.id.creatorname);
            creatorjob = itemView.findViewById(R.id.creatorjob);
            creatorpic = itemView.findViewById(R.id.creatorpic);
        }
    }
}
