package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CurrentRecieverList extends AppCompatActivity {

    private RecyclerView currentreceiverlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_reciever_list);

        currentreceiverlist = findViewById(R.id.CurrentReceiverListRecView);

        CurrentListReceiverRecViewAdapter adapter = new CurrentListReceiverRecViewAdapter();
        adapter.setList(CurrentReceiverClass.getAllCurrentReceivers());

        currentreceiverlist.setAdapter(adapter);
        currentreceiverlist.setLayoutManager(new LinearLayoutManager(this));
    }
}