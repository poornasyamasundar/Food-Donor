/*
    This class acts as the Adapter for the Recycler view of available receivers/current receivers in the app
    The Entire Class is straight forward.
*/
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

public class CurrentListReceiverRecViewAdapter extends RecyclerView.Adapter<CurrentListReceiverRecViewAdapter.ViewHolder>
{
    private ArrayList<CurrentReceiver> list = new ArrayList<>();

    public CurrentListReceiverRecViewAdapter()
    {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.current_donor_receiver_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.name.setText(holder.name.getText().toString()+list.get(position).getName());
        holder.phno.setText(holder.phno.getText().toString()+list.get(position).getPhno());
        holder.address.setText(holder.address.getText().toString()+list.get(position).getAddress());
        holder.email.setText(holder.email.getText().toString()+list.get(position).getEmail());
        holder.quantity.setText(holder.quantity.getText().toString() + list.get(position).getQuantity());
        holder.getDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+list.get(position).getLocality());
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

    public void setList(ArrayList<CurrentReceiver> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        private TextView address;
        private TextView phno;
        private TextView email;
        private Button getDir;
        private TextView quantity;
        public ViewHolder(@NonNull View itemview )
        {
            super(itemview);
            name = itemview.findViewById(R.id.currentname);
            address = itemview.findViewById(R.id.currentaddress);
            phno = itemview.findViewById(R.id.currentphno);
            getDir = itemview.findViewById(R.id.getDir);
            email = itemview.findViewById(R.id.currentemail);
            quantity = itemview.findViewById(R.id.currentQuantity);
        }
    }
}
