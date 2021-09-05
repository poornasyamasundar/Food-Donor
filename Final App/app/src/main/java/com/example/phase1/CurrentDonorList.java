
/*

This class deals with the logic for the page that lists all the currently willing donars using a RecylerView.
Here, we instantiate the adapter that we have defined and set this adapter as the adapter to the recyclerview.
We also pass the information required by the adapter object from here.

*/

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
