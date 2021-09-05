
/*

This class is used to define the logic of the page that provides an option to the user to change some of his basic details and save those changes into the database.
This sets the text of the TextView and EditView elements present in the related page whenever the page is opened.
It also implements onClickListener's for the buttons present in that page.

*/

package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Editablepage extends AppCompatActivity {

    private TextView text1 , text2 , text3 , text4 , text5, text6, text7;
    private Button changeBtn;
    RecyclerView editcomments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editablepage);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);
        changeBtn = findViewById(R.id.changeBtn);
        editcomments = findViewById(R.id.editFeedback);


        String PREF_NAME = "PreName";
        int PRIVATE_MODE = 0;
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        User user = UserClass.getUser(pref.getString("username", null));

        text1.setText(user.getName());
        text2.setText(user.getPhno());
        text3.setText(user.getEmail());
        text4.setText(user.getDoorNO());
        text5.setText(user.getArea());
        text6.setText(user.getDoorNO()+", "+user.getArea());
        text7.setText(Encryption.decrypt(user.getPassword()));

        EditFeedbackRecView adapter = new EditFeedbackRecView();
        adapter.setList(FeedBackClass.getComments(user.getName()));

        editcomments.setAdapter(adapter);
        editcomments.setLayoutManager(new LinearLayoutManager(this));

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMsg();
            }
        });

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setName(text1.getText().toString());
                user.setPhno(text2.getText().toString());
                user.setEmail(text3.getText().toString());
                user.setDoorNO(text4.getText().toString());
                user.setArea((text5.getText().toString()));
                user.setPassword(Encryption.encrypt(text7.getText().toString()));
                UserClass.updateUser(user);
                Toast.makeText(Editablepage.this, "Details Updated successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void toastMsg()
    {
        Toast.makeText(this,"Can't change this value" , Toast.LENGTH_SHORT).show();
    }
}
