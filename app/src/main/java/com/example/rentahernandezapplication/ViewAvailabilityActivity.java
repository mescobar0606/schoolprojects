package com.example.rentahernandezapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

public class ViewAvailabilityActivity extends AppCompatActivity {
    private AvailabilitySQLdb dbHandler;
    private EditText EventName;
    private CalendarView CalendarView;
    private String selectedDate;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_availability);
        EventName = (EditText) findViewById(R.id.etEventNameAvailability);
        CalendarView = (CalendarView) findViewById(R.id.calendarView3);
        CalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull android.widget.CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = Integer.toString(year) + Integer.toString(month) + Integer.toString(dayOfMonth);
                ReadDatabase(view);
            }
        });
        try {
            dbHandler = new AvailabilitySQLdb(ViewAvailabilityActivity.this, "CalendarDatabase", null, 1);
            sqLiteDatabase = dbHandler.getWritableDatabase();
            sqLiteDatabase.execSQL("CREATE TABLE Eventcalendar (Date TEXT, Event Text)");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public  void  InsertDatabase(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date", selectedDate);
        contentValues.put("Event",EventName.getText().toString());
        sqLiteDatabase.insert("EventCalendar", null, contentValues);
    }
    public void ReadDatabase(View view){
        String query = "Select Event from Eventcalendar where Date = " + selectedDate;
        try{
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            cursor.moveToLast();
            EventName.setText(cursor.getString(0));
        }
        catch (Exception exception){
            exception.printStackTrace();
            EventName.setText("");
        }
    }
}