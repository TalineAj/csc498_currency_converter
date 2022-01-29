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
            float converted_amount= 0;
            String input_usd = usd_amount.getText().toString();
            String input_lbp = lbp_amount.getText().toString();

            //Should we handle if the user wrote usd amount in the lbp place and vice-versa?

            //if the user enters an amount in the USD and doesnt enter an amount in lbp we should convert usd to lbp
            if((input_lbp).matches("")&& !((input_usd).matches(""))){
                converted_amount = usdConverter(Float.parseFloat(input_usd));
            }
            else if(!((input_lbp).matches(""))&& (input_usd).matches("")){
                //if the user does not enter an amount in the USD but enters an amount in lbp we should convert lbp to usd
                converted_amount = lbpConverter(Float.parseFloat(input_lbp));
            }
            else if(!((input_lbp).matches("")) && !((input_usd).matches(""))){
                Toast toast2 = Toast.makeText(getApplicationContext(),"Specify only one field please",Toast.LENGTH_LONG);
                toast2.show();
            }
            //If the user does not write in any, it will display the amount is 0.0
            String message = "The amount is "+ converted_amount ;
            Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG);
            toast.show();
        }
        public float usdConverter(float usd){
         return usd* 22000;
        }
        public float lbpConverter(float lbp){
        return lbp/22000;
        }
}