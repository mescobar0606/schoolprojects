package com.example.rentahernandezapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaring application variables
    private TextView Welcome;
    private Button Customer;
    private Button Management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Assigning values to variables
        Welcome = (TextView) findViewById(R.id.tvWelcome);

//Activating OnClickListener for Customer button
        Button Customer = (Button) findViewById(R.id.btnCustomer);
        Customer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, CustomerActivity.class));

            }
        });
//Activating OnClickListener for Management button
        Button Management = (Button) findViewById(R.id.btnManagement);
        Management.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, ManagementLogIn.class));
            }
        });

    }
}




