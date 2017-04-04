package com.example.myapp;

import android.app.Activity;

import android.os.Bundle;

import java.util.Calendar;


public class DateTimeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        final Calendar calendar = Calendar.getInstance();
    }
}
