package com.lau.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usd_amount;
    EditText lbp_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usd_amount = (EditText) findViewById(R.id.usd_amount);
        lbp_amount = (EditText) findViewById(R.id.lbp_amount);
    }
    public void convert( View view){
             

        String message = "The amount is";
        Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG);
        toast.show();
    }
}