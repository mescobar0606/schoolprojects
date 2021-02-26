package com.example.rentahernandezapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Intent.createChooser;

public class BookRentalActivity extends AppCompatActivity {
//Declaring variables
    private EditText YourName;
    private EditText YourEmail;
    private EditText YourPhoneNumber;
    private EditText InquiryMessage;
    private Button SendInquiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_rental);
//Assigning value to variables
        YourName = (EditText)findViewById(R.id.etYourName);
        YourEmail = (EditText)findViewById(R.id.etEmail);
        YourPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        InquiryMessage = (EditText)findViewById(R.id.etInquiry);
        SendInquiry = (Button)findViewById(R.id.btnSendInquiry);
//Obtaining name, phone, email, and message from user input and passing as string
        SendInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail(YourName.getText().toString(), YourEmail.getText().toString(), YourPhoneNumber.getText().toString(), InquiryMessage.getText().toString());
            }
        });
    }
//Creating intent to pass on strings and send via user email
    private void sendMail(String YourName, String YourEmail, String YourPhoneNumber, String InquiryMessage){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + "rentahernandez2018@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Rental inquiry from: " + YourName);
        intent.putExtra(Intent.EXTRA_TEXT, "Phone number: " + YourPhoneNumber + " Email; " + YourEmail + " " + InquiryMessage);
        try {
            startActivity(Intent.createChooser(intent, "Send email via..."));
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(BookRentalActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}