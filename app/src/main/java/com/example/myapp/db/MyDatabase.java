package com.example.myapp.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.myapp.model.Country;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ######.
 */

public class MyDatabase extends SQLiteOpenHelper {
    private Context context;
    private static String DB_NAME = "yu_db.sqlite";
    private static String DB_PATH ="/data/data/com.example.myapp/databases/";
    public SQLiteDatabase myDataBase;

    public MyDatabase(Context context) throws IOException {
        super(context, DB_NAME, null, 1);
        this.context = context;
        Log.i("MyDatabase", "Start Constructor");
        boolean isDbExist = checkDatabase();

        if(isDbExist) {
            openDatabase();
        } else {
            System.err.println("DB doesn't exists!");
            createDatabase();
        }
        Log.i("MyDatabase", "End of Constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Custom Method Here ....
    public List<Country> getAllCountryData() {
        List<Country> lst = new ArrayList<Country>();

        openDatabase();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM country_tb", null);
        Log.i("getAllCountryData", ""+cursor.getCount());
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Country country = new Country(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            lst.add(country);
            cursor.moveToNext();
        }

        cursor.close();
        close();
        return lst;
    }


    private void openDatabase() throws SQLiteException {
        String dbPath = context.getDatabasePath(DB_NAME).getPath();
        Log.i("openDatabase Method", dbPath);
        if(myDataBase != null && myDataBase.isOpen()) {
            return;
        }
        myDataBase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    private void createDatabase() throws IOException {
        boolean isDbExist = checkDatabase();

        if(isDbExist) {
            //
        } else {
            this.getReadableDatabase();
            try{
                copyDatabase();
            } catch (IOException e) { throw new Error("Error occur copying data!"); }
        }
    }

    private boolean checkDatabase() {
        boolean flag = false;

        try {
            File file = new File(DB_PATH+DB_NAME);
            //flag = SQLiteDatabase.openDatabase(DB_PATH+DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
            flag = file.exists();
        } catch (SQLiteException sqe) {
            System.err.println("DB doesn't exists!");
        }
        Log.i("checkDatabase", "end");
        return flag;
    }

    private void copyDatabase() throws IOException {
        InputStream inputStream = context.getAssets().open(DB_NAME);
        OutputStream outputStream = new FileOutputStream(DB_PATH+DB_NAME);

        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);

        while (length > 0) {
            outputStream.write(buffer, 0, length);

            length = inputStream.read(buffer);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public synchronized void close() {
        if(myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }
}
