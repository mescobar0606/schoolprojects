package com.example.rentahernandezapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerGallery extends AppCompatActivity {
    private Button Desserts;
    private Button Chairs;
    private Button Tents;
    private Button Decorations;
    private Button Tables;
    private Button BounceHouses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_gallery);
//Assigning values to variables
        Desserts = (Button)findViewById(R.id.btnDesserts);
        Chairs = (Button)findViewById(R.id.btnChairs);
        Tents = (Button)findViewById(R.id.btnTent);
        Decorations = (Button)findViewById(R.id.btnDecorations);
        Tables = (Button)findViewById(R.id.btnTables);
        BounceHouses = (Button)findViewById(R.id.btnBounceHouse);
//Creating on click functions and link to next activity
        Desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerGallery.this,DessertsActivity.class));
            }
        });
        Chairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerGallery.this,ChairsActivity.class));
            }
        });
        Tents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerGallery.this,TentsActivity.class));
            }
        });
        Decorations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerGallery.this,DecorationsActivity.class));
            }
        });
        Tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerGallery.this,TablesActivity.class));
            }
        });
        BounceHouses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerGallery.this,BounceHousesActivity.class));
            }
        });
    }
}