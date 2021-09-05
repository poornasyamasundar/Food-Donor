package com.example.phase1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveDetails extends AppCompatActivity {

    private TextView name;
    private EditText address;
    private EditText phone;
    private EditText meals;
    private Button done;
    private EditText house;
    private EditText locality;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_details);

        name = findViewById(R.id.nameValue);
        address = findViewById(R.id.addressValue);
        phone = findViewById(R.id.phoneValue);
        meals = findViewById(R.id.mealsValue);
        done = findViewById(R.id.done);
        house = findViewById(R.id.houseValue);
        locality = findViewById(R.id.localityValue);

        String PREF_NAME = "PreName";
        int PRIVATE_MODE = 0;
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        User user = UserClass.getUser(pref.getString("username", null));

        name.setText(user.getName());
        phone.setText(user.getPhno());
        address.setText(user.getDoorNO()+", "+user.getArea());
        house.setText(user.getDoorNO());
        locality.setText(user.getArea());

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkValid(phone.getText().toString()) || !checkValid(meals.getText().toString()))
                {
                    toastMsg();
                }
                else if(phone.getText().toString().length() != 10)
                {
                    toastMsg();
                }
                else if(house.getText().toString().length()==0 || locality.getText().toString().length()==0 || address.getText().toString().length()==0)
                {
                    toastMsg2();
                }
                else
                {
                    CurrentReceiver r = new CurrentReceiver();
                    r.setName(name.getText().toString());
                    r.setEmail(user.getEmail());
                    r.setAddress(address.getText().toString());
                    r.setLocality(locality.getText().toString());
                    r.setPhno(phone.getText().toString());
                    r.setQuantity(Integer.valueOf(meals.getText().toString()));

                    Receiver receiver = new Receiver();
                    receiver.setName(r.getName());
                    receiver.setEmail(r.getEmail());
                    receiver.setPhno(r.getPhno());
                    receiver.setAddress(r.getAddress());

                    CurrentReceiverClass.insertCurrentReceiver(r);
                    
                    if( ReceiverClass.getReceiver(receiver.getName()) == null ) {
                        ReceiverClass.insertReceiver(receiver);
                    }
                    Toast.makeText(ReceiveDetails.this, "You're now an available Receiver", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

    public boolean checkValid(String s)
    {
        for(int i=0 ; i<s.length() ; i++)
        {
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }

        return true;
    }

    public void toastMsg()
    {
        Toast.makeText(this,"Data entered for Phone number or meals is Invalid!!!" , Toast.LENGTH_SHORT).show();
    }

    public void toastMsg2()
    {
        Toast.makeText(this,"Enter Location details properly!!!" , Toast.LENGTH_SHORT).show();
    }
}