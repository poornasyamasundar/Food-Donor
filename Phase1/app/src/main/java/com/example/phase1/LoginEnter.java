package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginEnter extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_enter);

        username = findViewById(R.id.username);
        password = findViewById(R.id.Password);
        Register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = username.getText().toString();
                String p = password.getText().toString();
                User user = UserClass.getUser(u);
                if( user == null )
                {
                    Toast.makeText(LoginEnter.this, "UserName doesn't Exist", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if( !p.equals(user.getPassword()) )
                    {
                        Toast.makeText(LoginEnter.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                        Log.d("p = ", p);
                        Log.d("password = ", user.getPassword());
                        return;
                    }
                    String PREF_NAME = "PreName";
                    int PRIVATE_MODE = 0;
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", u);
                    editor.commit();
                    finish();
                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistration();
            }
        });
    }

    public void openRegistration()
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}