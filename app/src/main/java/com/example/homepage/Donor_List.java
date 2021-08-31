package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Donor_List extends AppCompatActivity {


    private ListView donor_list;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);
        donor_list = findViewById(R.id.donor_list);

        //ArrayList<String> donors = new ArrayList<>();

        ArrayAdapter<String> donors_adapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1, countryList
        );

        donor_list.setAdapter(donors_adapter);



    }
}