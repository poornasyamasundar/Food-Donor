package com.example.phase1;

import static android.R.layout.simple_list_item_multiple_choice;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userProfile extends AppCompatActivity {



    private TextView name;
    private TextView mail;
    private TextView text1 , text2 , text3 , text4 , text5;
    private Button editBtn;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile_list);


        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);

        text1.setText("Yashwanth");
        text2.setText("9390132226");
        text3.setText("yashwanthganna@gmail.com");
        text4.setText("Ramnathapur, telangan , india , eareth , milky wayhyderabad");
        text5.setText("Individual");
        name.setText("Yashwanth");
        mail.setText("yashwanthganna@gmail.com");

        editBtn = findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editable_page();
            }
        });


        /*String name = "Yashu";
        String comment = "how is the database";

        FeedBackClass.deleteComment(name , 5);

        FeedBackClass.modifyComment("Yashwanth" , 2 , comment);*/

        ArrayList<FeedBack> array = FeedBackClass.getAllComments();
        System.out.println(array.size());

    }

    public void editable_page()
    {
        Intent intent = new Intent( this , editData.class);
        startActivity(intent);
    }
}
