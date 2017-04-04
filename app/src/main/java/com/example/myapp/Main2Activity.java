package com.example.myapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.myapp.db.MyDatabase;

import java.io.IOException;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("Main2Activity", "start ...");

        try {
            int recordSize = new MyDatabase(this).getAllCountryData().size();
            Log.i("Main2Activity", "Record Size : "+recordSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
