package com.example.phase1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiverDetails extends AppCompatActivity {

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
        setContentView(R.layout.receive_details);

        name = findViewById(R.id.nameValue);
        address = findViewById(R.id.addressValue);
        phone = findViewById(R.id.phoneValue);
        meals = findViewById(R.id.mealsValue);
        done = findViewById(R.id.done);
        house = findViewById(R.id.houseValue);
        locality = findViewById(R.id.localityValue);

        name.setText("Yashwanth");
        address.setText("Hyderabad");
        phone.setText("9390132226");
        house.setText("y");
        locality.setText("y");


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkValid(phone.getText().toString()) || !checkValid(meals.getText().toString()))
                {
                    toastMsg();
                }
                if(phone.getText().toString().length() != 10 || meals.getText().toString().length()==0)
                {
                    toastMsg();
                }
                if(house.getText().toString().length()==0 || locality.getText().toString().length()==0 || address.getText().toString().length()==0)
                {
                    toastMsg2();
                }

                // other functionalities to be added
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
