package com.example.phase1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackPage extends AppCompatActivity {
    private TextView name;
    private EditText feedback;
    private Button save;
    private Button delete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page);

        name = findViewById(R.id.name);
        feedback = findViewById(R.id.feedback);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);

        name.setText("Yashwanth");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(feedback.getText().toString().length()==0 || feedback.getText().toString().length()>1000)
                {
                    toastMsg();
                }

                // other functionalities to be added
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void toastMsg()
    {
        Toast.makeText(this,"Make sure the feedback is non-empty and has characters not more than 1000!!!" , Toast.LENGTH_SHORT).show();
    }
}
