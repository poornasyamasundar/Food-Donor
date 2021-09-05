/*
    This Class handles the login activity.
    If the user is not logged in already into the app then the user need to login with his username and password.
    If the user is a new user he can register by clicking the register button.
    It first checks if the username exists or not
    then checks if the password is correct or not.
    If both of them are correct then the user can view his profile by going back to the home page.
    the user need to login only once in a device, the login information is stored in the device itself.
*/
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
                String p = Encryption.encrypt(password.getText().toString());
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
                    Toast.makeText(LoginEnter.this,"Login Successful", Toast.LENGTH_SHORT).show();
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
