package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by aungaung on 10/7/2016.
 */

public class MediaActivity extends Activity {

    ListView lstView;
    MediaArrayAdapter mediaArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_main);

        lstView = (ListView) findViewById(R.id.lstMedia);
        mediaArrayAdapter = new MediaArrayAdapter(getApplicationContext(), R.layout.media_item_layout);

        lstView.setAdapter(mediaArrayAdapter);
    }
}
