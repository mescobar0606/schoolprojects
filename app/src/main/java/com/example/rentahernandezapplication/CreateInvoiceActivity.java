package com.example.rentahernandezapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateInvoiceActivity extends AppCompatActivity {

    private ArrayList<String> Itemdata = new ArrayList<String>();
    private ArrayList<String> Pricedata = new ArrayList<String>();
    private ArrayList<String> Quantitydata = new ArrayList<String>();
    private ArrayList<String> Totaldata = new ArrayList<String>();

    private TableLayout InvoiceTable;
    private EditText Item;
    private EditText Price;
    private EditText Quantity;
    private EditText Subtotal;
    private EditText Payment;
    private EditText Balance;
    private Button CreateInvoice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_invoice_actvity);

        Item = (EditText)findViewById(R.id.etItem);
        Price = (EditText)findViewById(R.id.etPrice);
        Quantity = (EditText)findViewById(R.id.etQuantity);
        Subtotal = (EditText)findViewById(R.id.etSubtotal);
        Payment = (EditText)findViewById(R.id.etPayment);
        Balance = (EditText)findViewById(R.id.etBalance);
        CreateInvoice = (Button)findViewById(R.id.btnAddItem);
        Payment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int subtotal = Integer.parseInt((Payment.getText().toString()));
                int pay = Integer.parseInt(Subtotal.getText().toString());
                int bal = pay - subtotal;
                Balance.setText(String.valueOf(bal));

            }
        });

        CreateInvoice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add();

            }
        });
    }
    public void add()
    {
        int tot;
        String ItemName = Item.getText().toString();
        int ItemPrice = Integer.parseInt(Price.getText().toString());
        int ItemQuantity = Integer.parseInt(Quantity.getText().toString());
        tot = ItemPrice * ItemQuantity;

        Itemdata.add(ItemName);
        Pricedata.add(String.valueOf(ItemPrice));
        Quantitydata.add(String.valueOf(ItemQuantity));
        Totaldata.add(String.valueOf(tot));

        TableLayout table = (TableLayout) findViewById(R.id.InvoiceTable);
        TableRow row = new TableRow(CreateInvoiceActivity.this);
        TextView t1 = new TextView(CreateInvoiceActivity.this);
        TextView t2 = new TextView(CreateInvoiceActivity.this);
        TextView t3 = new TextView(CreateInvoiceActivity.this);
        TextView t4 = new TextView(CreateInvoiceActivity.this);

        String total;
        int sum = 0;
        for(int i = 0; i<Itemdata.size(); i ++)
        {
            String iname = Itemdata.get(i);
            String prc = Pricedata.get(i);
            String qty = Quantitydata.get(i);
            total = Totaldata.get(i);

            t1.setText(iname);
            t2.setText(prc);
            t3.setText(qty);
            t4.setText(total);

            sum = sum + Integer.parseInt(Totaldata.get(i).toString());
        }
        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        table.addView(row);

        Subtotal.setText (String.valueOf(sum));
        Item.setText("");
        Price.setText("");
        Quantity.setText("");
        Item.requestFocus();



    }
}
