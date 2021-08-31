package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private MaterialCardView cardView;
    private MaterialCardView cardView1;
    private Button donate_btn;
    private Button receive_btn;
    private Button view_donors;
    private Button view_receivers;

//    private ListView top_donors;
//    String top_donors_list[] = {"Barcelona", "Madrid", "Munich", "Manchester", "Paris", "London"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        donate_btn = (Button) findViewById(R.id.DonateButton);
        donate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        receive_btn = (Button) findViewById(R.id.RecieveButton);
        receive_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Receiving", Toast.LENGTH_SHORT).show();
            }
        });

        view_donors = (Button) findViewById(R.id.view_donors);
        view_donors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewDonors();
            }
        });

        view_receivers = (Button) findViewById(R.id.view_receivers);
        view_receivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewReceivers();
            }
        });

//        top_donors = findViewById(R.id.top_donors);
//
//        //ArrayList<String> donors = new ArrayList<>();
//
//        ArrayAdapter<String> donors_adapter = new ArrayAdapter<>(
//                this,android.R.layout.simple_list_item_1, top_donors_list
//        );
//
//        top_donors.setAdapter(donors_adapter);
    }
    public void openViewDonors(){
        Intent intent = new Intent(this, Donor_List.class);
        startActivity(intent);
    }

    public void openViewReceivers() {
        Intent intent = new Intent(this, Receiver_List.class);
        startActivity(intent);
    }
}