package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CurrentDonorList extends AppCompatActivity {

    private RecyclerView currentdonorlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_donor_list);

        currentdonorlist = findViewById(R.id.CurrentDonorListRecView);

        CurrentListRecViewAdapter adapter = new CurrentListRecViewAdapter();
        adapter.setList(CurrentDonorsClass.getAllCurrentDonors());

        currentdonorlist.setAdapter(adapter);
        currentdonorlist.setLayoutManager(new LinearLayoutManager(this));
    }
}