package com.example.rentahernandezapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class ManagementActivity extends AppCompatActivity {

//Declaring variables
    private Button Invoice;
    private Button Calendar;
    private Button CustomerInfo;
    private Button Availability;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
//Assigning values to variables
        Invoice = (Button)findViewById(R.id.btnInvoice);
        Calendar = (Button)findViewById(R.id.btnCalendar);
        CustomerInfo = (Button)findViewById(R.id.btnCustomerInfo);
        Availability = (Button)findViewById(R.id.btnAvailability);
//Creating on click functions to start next activity
        Invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagementActivity.this, CreateInvoiceActivity.class));
            }
        });

        Calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagementActivity.this, ViewCalendarActivity.class));
            }
        });
        CustomerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagementActivity.this, ViewCustomerActivity.class));
            }
        });
        Availability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagementActivity.this, ViewAvailabilityActivity.class));
            }
        });


    }
}