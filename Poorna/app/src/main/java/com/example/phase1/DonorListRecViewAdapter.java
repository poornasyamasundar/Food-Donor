package com.example.phase1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// this function implements an adapter for the recycler view for viewing donors.
public class DonorListRecViewAdapter extends RecyclerView.Adapter<DonorListRecViewAdapter.ViewHolder>
{
    private ArrayList<Donor> list = new ArrayList<>();

    public DonorListRecViewAdapter()
    {
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.donorlistitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.donorname.setText(list.get(position).getName());
        holder.donorphno.setText(list.get(position).getPhno());
        holder.donoraddress.setText(list.get(position).getAddress());
        if( !list.get(position).getType() )
        {
            holder.image.setImageResource(R.drawable.institute);
        }
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void setList(ArrayList<Donor> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView donorname;
        private TextView donoraddress;
        private TextView donorphno;
        private ImageView image;
        public ViewHolder(@NonNull View itemview )
        {
            super(itemview);
            donorname = itemview.findViewById(R.id.donorname);
            donoraddress = itemview.findViewById(R.id.donoraddress);
            donorphno = itemview.findViewById(R.id.donorphno);
            image = itemview.findViewById(R.id.image);
        }
    }
}
