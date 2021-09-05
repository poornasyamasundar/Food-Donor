/*

This function is used to manipulate the ReceiverList viewing page of the app.
We pass the required data to the adapter and then set this adapter to the RecyclerView

*/


package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


public class ReceiverListActivity extends AppCompatActivity {

    private RecyclerView receiverList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_list);

        receiverList = findViewById(R.id.ReceiverListRecView);

        ReceiverListRecViewAdapter adapter = new ReceiverListRecViewAdapter();
        adapter.setList(ReceiverClass.getAllReceivers());

        receiverList.setAdapter(adapter);
        receiverList.setLayoutManager(new LinearLayoutManager(this));
    }
}
