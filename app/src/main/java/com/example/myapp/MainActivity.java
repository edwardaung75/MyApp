package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Double2;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    EditText txtNumOne;
    EditText txtNumTwo;
    Button btnAdd;
    TextView lblResult;
    CheckBox chkMeat;
    CheckBox chkCheese;

    //EditText txtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //txtname = (EditText) findViewById(R.id.txtName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_number_layout);

        /*txtNumOne = (EditText) findViewById(R.id.txtNumOne);
        txtNumTwo = (EditText) findViewById(R.id.txtNumTwo);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lblResult = (TextView) findViewById(R.id.lblResult);
        chkMeat = (CheckBox) findViewById(R.id.chkMeat);
        chkCheese = (CheckBox) findViewById(R.id.chkCheese);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Add Button Click", Toast.LENGTH_LONG).show();

                double numone = Double.parseDouble(txtNumOne.getText().toString());
                double numtwo = Double.parseDouble(txtNumTwo.getText().toString());
                lblResult.setText("Num1 + Num2 = "+ (numone + numtwo));
            }
        });*/
        /*final EditText txtName = (EditText) findViewById(R.id.txtName);
        Button btnClick = (Button) findViewById(R.id.btnClick);
        final TextView lblGreeting = (TextView) findViewById(R.id.lblGreeting);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();

                lblGreeting.setText("Hello " + txtName.getText());
            }
        });*/


    }

    /*public void addNumber(View v) {

    }*/

    public void sendMessaage(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
