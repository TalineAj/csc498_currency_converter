package com.lau.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usd_amount;
    EditText lbp_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The code in line 21-->28 is not my own code, it was retrieved when I searched how to change the status bar color from:
        //https://www.geeksforgeeks.org/how-to-change-the-color-of-status-bar-in-an-android-app/
        //N.b: I also did some google search to change the button color as well as add the flag picture
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.red));
        }

        usd_amount = (EditText) findViewById(R.id.usd_amount);
        lbp_amount = (EditText) findViewById(R.id.lbp_amount);
    }
        public void convert( View view){
            float converted_amount= 0;
            String input_usd = usd_amount.getText().toString();
            String input_lbp = lbp_amount.getText().toString();


            //I did not handle the case if the user did not write a number since I already specified that it is a float text in layout

            //if the user enters an amount in the USD and does not enter an amount in lbp we should convert usd to lbp
            if((input_lbp).matches("")&& !((input_usd).matches(""))){
                converted_amount = usdConverter(Float.parseFloat(input_usd));
                lbp_amount.setText(Float.toString(converted_amount));
            }
            else if(!((input_lbp).matches(""))&& (input_usd).matches("")){
                //if the user does not enter an amount in the USD but enters an amount in lbp we should convert lbp to usd
                converted_amount = lbpConverter(Float.parseFloat(input_lbp));
                usd_amount.setText(Float.toString(converted_amount));
            }
            else if(!((input_lbp).matches("")) && !((input_usd).matches(""))){
                // user specifies both fields
                Toast toast = Toast.makeText(getApplicationContext(),"Please specify only one field",Toast.LENGTH_LONG);
                toast.show();
            }
            else{ //user does not specify any field
                Toast toast1 = Toast.makeText(getApplicationContext(),"Please specify at least one field",Toast.LENGTH_LONG);
                toast1.show();
            }
        }
        public float usdConverter(float usd){
        //converts usd to lbp on 22000 rate
        return usd* 22000;
        }
        public float lbpConverter(float lbp){
        //converts lbp to usd on 22000 rate
        return lbp/22000;
        }
}