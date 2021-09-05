/*
    This class handles the home page of the app. 
    All the other activities are opened from this activity.
    The straight forward ones are opening all the lists
    There is a recycler view to display feedbacks.
    The Total number of users, donors, receivers are also displayed in the home page.
    Most of the code is straight forward.
*/
package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button view_donors;
    private Button view_receivers;
    private Button userprofile;
    private Button donate;
    private Button receive;
    private Button currentDonors;
    private Button currentReceivers;
    private TextView noofdonors;
    private TextView noofreceivers;
    private TextView noofusers;
    private RecyclerView feedback;
    private Button newComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userprofile = (Button) findViewById(R.id.user_profile);
        String PREF_NAME = "PreName";
        int PRIVATE_MODE = 0;
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        if( pref.getString("username", null ) == null )
        {
            userprofile.setText("Login");
        }
        else
        {
            userprofile.setText("View Profile");
        }

        noofdonors = findViewById(R.id.noofdonors);
        noofreceivers = findViewById(R.id.noofReceivers);
        noofusers = findViewById(R.id.noofusers);
        if( DonorClass.getCount() != -1 ) {
            noofdonors.setText(noofdonors.getText().toString() + DonorClass.getCount());
        }
        if( ReceiverClass.getCount() != -1 )
        {
            noofreceivers.setText(noofreceivers.getText().toString() + ReceiverClass.getCount() );
        }
        if( UserClass.getCount() != -1 )
        {
            noofusers.setText(noofusers.getText().toString() + UserClass.getCount());
        }

        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginOrNot = userprofile.getText().toString();
                if( loginOrNot == "Login" )
                {
                    openLogin();
                }
                else
                {
                    openProfile();
                }
            }
        });

        view_donors = (Button) findViewById(R.id.viewDonors);
        view_donors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewDonors();
            }
        });

        view_receivers = (Button) findViewById(R.id.viewReceivers);
        view_receivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewReceivers();
            }
        });

        currentDonors = (Button) findViewById(R.id.viewAvailableDonors);
        currentDonors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCurrentDonors();
            }
        });

        currentReceivers = (Button) findViewById(R.id.viewAvailableReceivers);
        currentReceivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCurrentReceivers();
            }
        });

        newComment = (Button) findViewById(R.id.newComment);
        newComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( pref.getString("username", null ) == null )
                {
                    Toast.makeText(MainActivity.this, "Login to Comment", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    openNewCommentActivity();
                }
            }
        });

        feedback = findViewById(R.id.FeedbackRecView);
        FeedbackRecView adapter = new FeedbackRecView();
        adapter.setList(FeedBackClass.getAllComments());

        feedback.setAdapter(adapter);
        feedback.setLayoutManager(new LinearLayoutManager(this));

        donate = (Button) findViewById(R.id.DonateButton);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String PREF_NAME = "PreName";
                int PRIVATE_MODE = 0;
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                User user = UserClass.getUser(pref.getString("username", null));
                if( user == null )
                {
                    Toast.makeText(MainActivity.this, "Login to become a donor", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    openDonateDetails();
                }
            }
        });

        receive = (Button) findViewById(R.id.RecieveButton);
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PREF_NAME = "PreName";
                int PRIVATE_MODE = 0;
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                User user = UserClass.getUser(pref.getString("username", null));
                if( user == null )
                {
                    Toast.makeText(MainActivity.this, "Login to become a Receiver", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    openReceiveDetails();
                }
            }
        });
    }

    public void openViewDonors(){
        Intent intent = new Intent(this, DonorListActivity.class);
        startActivity(intent);
    }

    public void openViewReceivers() {
        Intent intent = new Intent(this, ReceiverListActivity.class);
        startActivity(intent);
    }

    public void openCurrentDonors()
    {
        Intent intent = new Intent(this, CurrentDonorList.class);
        startActivity(intent);
    }

    public void openCurrentReceivers()
    {
        Intent intent = new Intent(this, CurrentRecieverList.class);
        startActivity(intent);
    }

    public void openDonateDetails()
    {
        Intent intent = new Intent( this, DonateDetails.class);
        startActivity(intent);
    }

    public void openReceiveDetails()
    {
        Intent intent = new Intent(this, ReceiveDetails.class);
        startActivity(intent);
    }

    public void openNewCommentActivity()
    {
        Intent intent = new Intent(this, NewComment.class);
        startActivity(intent);
        startActivity(getIntent());
    }

    public void openProfile()
    {
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
        startActivity(getIntent());
    }

    public void openLogin()
    {
        Intent intent = new Intent(this, LoginEnter.class);
        startActivity(intent);
        startActivity(getIntent());
    }
}
