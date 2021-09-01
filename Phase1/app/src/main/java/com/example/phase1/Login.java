package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText edttextname,edttxtusername,edttxtmail,edttxtpass,
            edttxtrepass,edttxtaddress;
    private Button btnsubmit;
    private RadioGroup radioGroup;
    private CheckBox chkagree;
    private RelativeLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });
    }

    private void initRegister()
    {
        if(validateData()) {
            if (chkagree.isChecked()) {
                //String Name,String Mail,String Pass,String Adress,String Institute,int gender
                RadioButton gender1 = findViewById(R.id.radiomale);
                RadioButton gender2 = findViewById(R.id.radiofemale);
                int s;
                if (gender1.isChecked())
                    s = 1;
                else if (gender2.isChecked())
                    s = 2;
                else
                    s = 3;
                User user = new User();
                user.setName(edttextname.getText().toString());
                user.setUserName(edttxtusername.getText().toString());
                user.setEmail(edttxtmail.getText().toString());
                user.setPassword(edttxtpass.getText().toString());
                user.setArea(edttxtaddress.getText().toString());
                UserClass.insertUser(user);
                finish();
            } else {
                Toast.makeText(this, "You need to agree to the licence agrement", Toast.LENGTH_SHORT).show();
            }
            //to data base
        }
    }

    private boolean validateData(){
        if(edttextname.getText().toString().equals("")){
            Toast.makeText(this, "Name is Empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edttxtmail.getText().toString().equals("")){
            Toast.makeText(this, "Mail is Empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if( edttxtpass.getText().toString().length() < 8 )
        {
            Toast.makeText(this, "Password should be at least 8 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edttxtpass.getText().toString().equals("")){
            Toast.makeText(this, "Enter valid password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edttxtrepass.getText().toString().equals("")){
            Toast.makeText(this, "Re-Enter the password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!edttxtpass.getText().toString().equals(edttxtrepass.getText().toString())){
            Toast.makeText(this, "Both Passwords should be same", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edttxtaddress.getText().toString().equals("")){
            Toast.makeText(this, "Address is Empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edttxtusername.getText().toString().equals("") )
        {
            Toast.makeText(this, "Username is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if( !UserClass.checkUser(edttxtusername.getText().toString()) )
        {
            Toast.makeText(this, "UserName is already Taken", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private  void initViews(){
        Log.d(TAG, "initViews: initViews: Started");
        edttextname = findViewById(R.id.edttextname);
        edttxtusername = findViewById(R.id.edttxtusername);
        edttxtmail = findViewById(R.id.edttxtmail);
        edttxtpass = findViewById(R.id.edttxtpass);
        edttxtrepass = findViewById(R.id.edttxtrepass);
        edttxtaddress = findViewById(R.id.edttxtaddress);

        btnsubmit = findViewById(R.id.btnsubmit);

        radioGroup = findViewById(R.id.radioGroup);
        chkagree = findViewById(R.id.chkagree);
        parent = findViewById(R.id.parent);
    }
}