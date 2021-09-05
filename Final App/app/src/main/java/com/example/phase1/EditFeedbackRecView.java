/*

This has the logic to implement a RecyclerView.
This is not used anywhere in the app.

*/

package com.example.phase1;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditFeedbackRecView extends RecyclerView.Adapter<EditFeedbackRecView.ViewHolder>
{
    private ArrayList<FeedBack> list = new ArrayList<>();

    public EditFeedbackRecView()
    {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.edit_feedback_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.name.setText(list.get(position).getName());
        holder.date.setText(list.get(position).getDate()+"-"+list.get(position).getMonth()+"-"+list.get(position).getYear());
        holder.feedback.setText(list.get(position).getComment());
        holder.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setComment(holder.feedback.getText().toString());
                FeedBackClass.modifyComment(list.get(position));
                Toast.makeText(holder.itemView.getContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedBackClass.deleteComment(list.get(position));
                Toast.makeText(holder.itemView.getContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show();
                list.remove(position);
                notifyDataSetChanged();
            }
        });
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
        private EditText feedback;
        private Button save;
        private Button delete;
        public ViewHolder(@NonNull View itemview )
        {
            super(itemview);
            name = itemview.findViewById(R.id.feedbackername);
            date = itemview.findViewById(R.id.feedbackDate);
            feedback = itemview.findViewById(R.id.feedback);
            save = itemview.findViewById(R.id.saveedit);
            delete = itemview.findViewById(R.id.deleteFeedback);
        }
    }
}
