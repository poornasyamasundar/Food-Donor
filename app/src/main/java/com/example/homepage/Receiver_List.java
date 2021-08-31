package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Receiver_List extends AppCompatActivity {


    private ListView receiver_list;
    String cities_list[] = {"Barcelona", "Madrid", "Munich", "Manchester", "Paris", "London"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_list);

        receiver_list = findViewById(R.id.receiver_list);

        //ArrayList<String> donors = new ArrayList<>();

        ArrayAdapter<String> donors_adapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1, cities_list
        );

        receiver_list.setAdapter(donors_adapter);
    }
}