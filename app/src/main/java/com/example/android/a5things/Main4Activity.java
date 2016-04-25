package com.example.android.a5things;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

import static java.lang.Math.round;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void goBack(View view) {
        this.finish();
    }

    public void calculate(View view) throws ParseException {
        EditText price = (EditText) findViewById(R.id.prix);
        EditText reduc = (EditText) findViewById(R.id.reduc);
        String SPrice = price.getText().toString();
        String SReduc = reduc.getText().toString();
        String Result1;
        String Result2;
        float fPrix = 0;
        float fReduc = 0;
        float fTotal = 0;
        float fMoins = 0;
        if (SPrice.matches("")) {
            Toast.makeText(this, "Vous n'avez pas entré de prix", Toast.LENGTH_SHORT).show();
            return;
        } else
            fPrix = Float.valueOf(SPrice);
        if (SReduc.matches("")) {
            Toast.makeText(this, "Vous n'avez pas entré de reduction", Toast.LENGTH_SHORT).show();
            return;
        } else
            fReduc = Float.valueOf(SReduc);
        fTotal = fPrix - (fPrix * fReduc / 100);
        fMoins = fPrix * fReduc / 100;
        Result1 = "Prix après réduction: " + fTotal + " €";
        Result2 = "Total de la réduction: " + fMoins + " €";
        displayInfo(Result1, Result2);
    }
    private void displayInfo(String Result1, String Result2) {
        TextView ResultTextView = (TextView) findViewById(R.id.total);
        ResultTextView.setText(Result1);
        TextView ResultTextView2 = (TextView) findViewById(R.id.moins);
        ResultTextView2.setText(Result2);
    }
}
