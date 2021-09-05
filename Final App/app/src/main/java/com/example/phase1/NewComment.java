package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewComment extends AppCompatActivity {

    private TextView name;
    private EditText feedback;
    private Button save;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comment);

        name = findViewById(R.id.name);
        feedback = findViewById(R.id.feedback);
        save = findViewById(R.id.save);
        back = findViewById(R.id.back);

        String PREF_NAME = "PreName";
        int PRIVATE_MODE = 0;
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        User user = UserClass.getUser(pref.getString("username", null));

        name.setText(user.getName());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(feedback.getText().toString().length()==0 || feedback.getText().toString().length()>1000)
                {
                    toastMsg();
                }
                else
                {
                    FeedBackClass.addComment(user.getName(), feedback.getText().toString());
                    Toast.makeText(NewComment.this,"Comment Added Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void toastMsg()
    {
        Toast.makeText(this,"Make sure the feedback is non-empty and has characters not more than 1000!!!" , Toast.LENGTH_SHORT).show();
    }
}