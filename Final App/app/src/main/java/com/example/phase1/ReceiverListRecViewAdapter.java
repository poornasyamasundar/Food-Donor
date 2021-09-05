package com.example.phase1;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReceiverListRecViewAdapter extends RecyclerView.Adapter<ReceiverListRecViewAdapter.ViewHolder>
{
    private ArrayList<Receiver> list = new ArrayList<>();

    public ReceiverListRecViewAdapter()
    {
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.receiverlistitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.receivername.setText(holder.receivername.getText().toString()+list.get(position).getName());
        holder.receiverphno.setText(holder.receiverphno.getText().toString()+list.get(position).getPhno());
        holder.receiveraddress.setText(holder.receiveraddress.getText().toString()+list.get(position).getAddress());
        holder.receiveremail.setText(holder.receiveremail.getText().toString()+list.get(position).getEmail());

        holder.getDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+list.get(position).getAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                holder.itemView.getContext().startActivity(mapIntent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void setList(ArrayList<Receiver> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView receivername;
        private TextView receiveraddress;
        private TextView receiverphno;
        private TextView receiveremail;
        private Button getDir;
        public ViewHolder(@NonNull View itemview )
        {
            super(itemview);
            receivername = itemview.findViewById(R.id.receivername);
            receiveraddress = itemview.findViewById(R.id.receiveraddress);
            receiverphno = itemview.findViewById(R.id.receiverphno);
            getDir = itemview.findViewById(R.id.getDir);
            receiveremail = itemview.findViewById(R.id.receiveremail);
        }
    }
}
