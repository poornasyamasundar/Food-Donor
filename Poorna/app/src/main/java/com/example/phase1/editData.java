package com.example.phase1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class editData extends AppCompatActivity {

    private TextView text1 , text2 , text3 , text4 , text7;
    private Button changeBtn;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editablepage);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text7 = findViewById(R.id.text7);
        changeBtn = findViewById(R.id.changeBtn);

        text1.setText("Yashwanth");
        text2.setText("9390132226");
        text3.setText("yashwanthganna@gmail.com");
       // text4.setText("Ramnathapur, telangan , india , eareth , milky wayhyderabad");
        text7.setText("Individual");

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMsg();
            }
        });

        text7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMsg();
            }
        });
    }

    public void toastMsg()
    {
        Toast.makeText(this,"Can't change this value" , Toast.LENGTH_SHORT).show();
    }
}
