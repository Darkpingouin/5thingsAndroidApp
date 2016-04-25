package com.example.android.a5things;

import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


import java.text.NumberFormat;
import java.text.ParseException;

public class Main6Activity extends AppCompatActivity {
    NumberFormat nf = NumberFormat.getNumberInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    public void goBack(View view) {
        this.finish();
    }

    public void calculate(View view) throws ParseException {
        EditText text = (EditText) findViewById(R.id.price);
        EditText test2 = (EditText) findViewById(R.id.tip);
        EditText people = (EditText) findViewById(R.id.people);
        String textTip = test2.getText().toString();
        String value = text.getText().toString();
        String peoo = people.getText().toString();
        float total = 0;
        float tip = 0;
        float price = 0;
        float pers = 0;

        if (value.matches("")) {
            Toast.makeText(this, "You did not enter a price", Toast.LENGTH_SHORT).show();
            return;
        } else
            price = Float.valueOf(value);
        if (textTip.matches("")) {
            Toast.makeText(this, "You did not enter tip percentage", Toast.LENGTH_SHORT).show();
            return;
        } else
            tip = Float.valueOf(textTip);
        if (peoo.matches("")) {
            Toast.makeText(this, "You did not enter a number of person", Toast.LENGTH_SHORT).show();
            return;
        } else
            pers = Float.valueOf(peoo);
        total = price + (price * (tip / 100));
        tip = price * (tip / 100);
        String result = "Total : " + Float.toString(total) + " €";
        String person = "Total par personne: " + Float.toString(total / pers) + " €";
        String tiptip = "Total de pourboire: " + Float.toString(tip) + " €";
        displayPrice(result, tiptip, person);

    }

    private void displayPrice(String total, String tip, String split) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        TextView peopleTextView = (TextView) findViewById(R.id.person_text_view);
        TextView tipTextView = (TextView) findViewById(R.id.tip_text_view);
        priceTextView.setText(total);
        peopleTextView.setText(split);
        tipTextView.setText(tip);
    }
}
