package com.example.sheredpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserActivity extends AppCompatActivity {

    SharedPreferences usrAccs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }
    public void signUp(View v){
        // To creat or open sharedpreference
        usrAccs = getApplicationContext().getSharedPreferences("UsersAccounts", 0);


        // To read username and password
        EditText usr = (EditText) findViewById(R.id.usrInp);
        EditText pwd = (EditText) findViewById(R.id.pwdInp);

        // To read the username and convert to string
        String usern = usr.getText().toString();
        String passw = pwd.getText().toString();

        // To create editor object for sharedPref to edit (add/ edit) values
        SharedPreferences.Editor userEdit = usrAccs.edit();

        // To check if the user exists
        if (usrAccs.contains(usern)) {
            Toast.makeText(getApplicationContext(), "User already Exists",
                    Toast.LENGTH_LONG).show();
            return;
        }
        // To store the new user info as (Key= user name, Value = password)
        userEdit.putString(usern, passw);
        userEdit.commit();

        Toast.makeText(getApplicationContext(), usr.getText().toString() + " Account is created", Toast.LENGTH_LONG).show();

        // To return To the main activity
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();


    }
}