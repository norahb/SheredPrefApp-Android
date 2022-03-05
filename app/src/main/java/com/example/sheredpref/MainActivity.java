package com.example.sheredpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtv = (TextView) findViewById(R.id.txtvSignUp);

        // Add listner to textview to open new activity
        txtv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        NewUserActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
public void usrLogIn(View v){
    // To link to the the view objects and read data
    EditText uname = (EditText) findViewById(R.id.nameInp);
    EditText upass = (EditText) findViewById(R.id.pwdInp);
    String username = uname.getText().toString();
    String userpass = upass.getText().toString();

    // To open sharedPref, Create if not exist
    SharedPreferences userAcc = getSharedPreferences("UsersAccounts", 0);

    if (!userAcc.contains(username)) {
        Toast.makeText(getApplicationContext(), "User NOT Exists",
                Toast.LENGTH_LONG).show();
        return;
    }

// To check if the entered password match the password stored in
// SharedPref object
    if (userAcc.getString(username, null).equals(userpass)) {
        Toast.makeText(getApplicationContext(), "Access Authenticated",
                Toast.LENGTH_LONG).show();
    }
    else {
        Toast.makeText(getApplicationContext(), "Password is wrong",
                Toast.LENGTH_LONG).show();
    }
}
}