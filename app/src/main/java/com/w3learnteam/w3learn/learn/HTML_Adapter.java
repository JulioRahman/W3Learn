package com.w3learnteam.w3learn.learn;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.w3learnteam.w3learn.R;
import com.w3learnteam.w3learn.quiz.QuizTime;

import java.util.ArrayList;

public class HTML_Adapter extends RecyclerView.Adapter<HTML_Adapter.Html_Holder>{

    private String TAG = QuizTime.class.getSimpleName();

    private SweetAlertDialog pDialog;

    private ArrayList<HTML> html_learn;

    public HTML_Adapter(ArrayList<HTML> html_learn){
        this.html_learn = html_learn;
    }

    @NonNull
    @Override
    public Html_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.html_item,parent,false);
        return new Html_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Html_Holder holder, final int position) {
        holder.titleHTML.setText(html_learn.get(position).getTitleHTML());
        holder.descHTML.setText(html_learn.get(position).getDescHTML());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "c: " + holder.titleHTML.getText(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (html_learn != null) ? html_learn.size() : 0;
    }

    public class Html_Holder extends RecyclerView.ViewHolder{

        private TextView titleHTML,descHTML;
        private LinearLayout parentLayout;

        public Html_Holder(@NonNull View itemView) {
            super(itemView);
            titleHTML = (TextView) itemView.findViewById(R.id.titlehtml);
            descHTML = (TextView) itemView.findViewById(R.id.deschtml);
            parentLayout = (LinearLayout) itemView.findViewById(R.id.parentLayout);
        }
    }
}
