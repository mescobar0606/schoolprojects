package com.example.rentahernandezapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewCustomerActivity extends AppCompatActivity {
    private ArrayList<String> CustomerName = new ArrayList<>();
    private ArrayList<String> CustomerPhone = new ArrayList<>();
    private ArrayList<String> CustomerEmail = new ArrayList<>();
    private ArrayList<String> CustomerAddress = new ArrayList<>();
    private mySQLQCustomerDB dbHandler;
    private SQLiteDatabase CustomerSQLDB;
    private TableLayout CustomerTable;
    private EditText Name;
    private EditText Phone;
    private EditText Email;
    private EditText Address;
    private Button AddCustomer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer);

        Name = (EditText) findViewById(R.id.etCustomerName);
        Phone = (EditText) findViewById(R.id.etCustomerPhoneNumber);
        Email = (EditText) findViewById(R.id.CustomerEmail);
        Address = (EditText) findViewById(R.id.CustomerAddress);
        AddCustomer = (Button) findViewById(R.id.btnAddCustomer);

        AddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }

        });
        //CustomerTable.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
             //   ReadDatabase();
        //    }
      //  });
        try {
            dbHandler = new mySQLQCustomerDB(ViewCustomerActivity.this, "CustomerView", null, 1);
            CustomerSQLDB = dbHandler.getWritableDatabase();
            CustomerSQLDB.execSQL("CREATE TABLE CustomerTable(Cname TEXT, Cphone TEXT, Cemail TEXT, Caddress TEXT)");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void InsertCustomerDB(View view) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Cname", Name.getText().toString());
            contentValues.put("Cphone", Phone.getText().toString());
            contentValues.put("Cemail", Email.getText().toString());
            contentValues.put("Caddress", Address.getText().toString());
    }
    public void ReadDatabase() {
        String query = "Select Event from CustomerTable";
        try {
            Cursor cursor = CustomerSQLDB.rawQuery(query, null);
            cursor.moveToLast();

        }
        catch (Exception exception){
            exception.printStackTrace();
            Name.setText("");
            Phone.setText("");
            Email.setText("");
            Address.setText("");

        }
    }

    public void add()
    {
        String customername = Name.getText().toString();
        String customerphone = Phone.getText().toString();
        String customeremail = Email.getText().toString();
        String customeraddress = Address.getText().toString();

        CustomerName.add(customername);
        CustomerPhone.add(customerphone);
        CustomerEmail.add(customeremail);
        CustomerAddress.add(customeraddress);

        TableLayout table = (TableLayout)findViewById(R.id.tbCustomerInfo);
        TableRow row = new TableRow(ViewCustomerActivity.this);
        TextView t1 = new TextView(ViewCustomerActivity.this);
        TextView t2 = new TextView(ViewCustomerActivity.this);
        TextView t3 = new TextView(ViewCustomerActivity.this);
        TextView t4 = new TextView(ViewCustomerActivity.this);

        String total;
        int sum = 0;
        for(int i = 0; i<CustomerName.size(); i ++)
        {
            String cname = CustomerName.get(i);
            String cphone = CustomerPhone.get(i);
            String cemail = CustomerEmail.get(i);
            String caddress = CustomerAddress.get(i);

            t1.setText(cname);
            t2.setText(cphone);
            t3.setText(cemail);
            t4.setText(caddress);
        }
        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        table.addView(row);

    }

}