package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView noofdonors;
    private TextView noofreceivers;
    private TextView noofusers;


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

        donate = (Button) findViewById(R.id.DonateButton);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Donor d = new Donor();
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
                    d.setName(user.getName());
                    d.setEmail(user.getEmail());
                    d.setAddress(user.getArea());
                    d.setPhno(user.getPhno());
                    DonorClass.insertDonor(d);
                }
            }
        });

        receive = (Button) findViewById(R.id.RecieveButton);
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Receiver r = new Receiver();
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
                    r.setName(user.getName());
                    r.setEmail(user.getEmail());
                    r.setAddress(user.getArea());
                    r.setPhno(user.getPhno());
                    ReceiverClass.insertReceiver(r);
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

    public void openProfile()
    {
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
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
    }

    public void openLogin()
    {
        Intent intent = new Intent(this, LoginEnter.class);
        startActivity(intent);
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
    }
}