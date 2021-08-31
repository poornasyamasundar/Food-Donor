package com.example.phase1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserProfile_RecViewAdapter extends RecyclerView.Adapter<UserProfile_RecViewAdapter.ViewHolder>{

    private ArrayList<String> values = new ArrayList<>();
    private ArrayList<String> keys = new ArrayList<>();

    public UserProfile_RecViewAdapter(){
        keys.add("Name");
        keys.add("Email");
        keys.add("Address");
        keys.add("Phone no.");
        keys.add("Type");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userprofile_item, parent , false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userKey.setText(keys.get(position));
        holder.userValue.setText(values.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public void setList(ArrayList<String> values)
    {
        this.values = values;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        private TextView userKey,userValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // userKey = itemView.findViewById(R.id.key);
           // userValue = itemView.findViewById(R.id.value);
        }
    }
}
