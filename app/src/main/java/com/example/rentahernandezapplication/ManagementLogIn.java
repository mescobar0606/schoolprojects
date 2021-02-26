package com.example.rentahernandezapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ManagementLogIn extends AppCompatActivity {
    //Declaring variables
    private EditText Username;
    private EditText Password;
    private Button Login;
    private TextView FailLogin;
    private int FailAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_log_in);
//Assigning Values to variables
        Username = (EditText) findViewById(R.id.tvUsername);
        Password = (EditText) findViewById(R.id.tvPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        FailLogin = (TextView) findViewById(R.id.tvFailLogin);
//Creating click listener and adding customer input into string
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

    }

    //Creating validation function//
    private void validate(String Username, String Password) {
        ///currently working on if else statement for security and to allow the app to check for password *********************
        if ((Username.equals("HernandezRentals")) && (Password.equals("2018"))) {
            Intent intent = new Intent(ManagementLogIn.this, ManagementActivity.class);
            startActivity(intent);

        }
        else {
            FailAttempts --;
            FailLogin.setText("Wrong login credentials. Please try again!");
            if (FailAttempts == 0) {
                FailLogin.setText("Too many incorrect attempts, Please contact management for assistance.");
                Login.setEnabled(false);
            }



        }
    }
}