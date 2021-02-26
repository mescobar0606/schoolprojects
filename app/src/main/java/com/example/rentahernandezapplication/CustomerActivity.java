package com.example.rentahernandezapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class CustomerActivity extends AppCompatActivity {

//Declaring Variables
    private Button Gallery;
    private Button Prices;
    private Button BookRental;
    private Button ContactUs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
//Assigning value to Variables
        Gallery = (Button)findViewById(R.id.btnGallery);
        Prices = (Button)findViewById(R.id.btnPrices);
        BookRental = (Button)findViewById(R.id.btnBookRental);
        ContactUs = (Button)findViewById(R.id.btnContactUs);

//Creating on click functions and link to next activity
        Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerActivity.this,CustomerGallery.class));
            }
        });
        Prices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerActivity.this,PricesActivity.class));
            }
        });
        BookRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerActivity.this,BookRentalActivity.class));
            }
        });
        ContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerActivity.this,ContactUsActivity.class));
            }
        });



    }
}