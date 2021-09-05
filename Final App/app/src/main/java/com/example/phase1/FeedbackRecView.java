package com.example.phase1;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedbackRecView extends RecyclerView.Adapter<FeedbackRecView.ViewHolder>
{
    private ArrayList<FeedBack> list = new ArrayList<>();

    public FeedbackRecView()
    {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.feedbacklistitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.name.setText(holder.name.getText().toString()+list.get(position).getName());
        holder.date.setText(holder.date.getText().toString()+list.get(position).getDate()+"-"+list.get(position).getMonth()+"-"+list.get(position).getYear());
        holder.feedback.setText(list.get(position).getComment());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void setList(ArrayList<FeedBack> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        private TextView date;
        private TextView feedback;
        public ViewHolder(@NonNull View itemview )
        {
            super(itemview);
            name = itemview.findViewById(R.id.feedbackername);
            date = itemview.findViewById(R.id.feedbackDate);
            feedback = itemview.findViewById(R.id.feedback);
        }
    }
}
