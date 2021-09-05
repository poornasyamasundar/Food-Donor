/*
This class deals with the logic for the page that lists all the currently willing receivers using a RecylerView.
Here, we instantiate the adapter that we have defined and set this adapter as the adapter to the recyclerview.
We also pass the information required by the adapter object from here.
*/
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
