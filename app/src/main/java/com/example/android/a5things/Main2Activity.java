package com.example.android.a5things;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void goBack(View view) {
        this.finish();
    }
    public void calculate(View view) throws ParseException {
        EditText taille = (EditText) findViewById(R.id.taille);
        EditText poids  = (EditText) findViewById(R.id.poids);

        String STaille = taille.getText().toString();
        String SPoids = poids.getText().toString();
        String Result;
        float total = 0;
        float fTaille = 0;
        float fPoids = 0;
        if (STaille.matches("")) {
            Toast.makeText(this, "Vous n'avez pas entré votre taille", Toast.LENGTH_SHORT).show();
            return;
        } else
            fTaille = Float.valueOf(STaille);
        if (SPoids.matches("")) {
            Toast.makeText(this, "Vous n'avez pas entré votre poids", Toast.LENGTH_SHORT).show();
            return;
        } else
            fPoids = Float.valueOf(SPoids);
        total = fPoids / ((fTaille / 100) * (fTaille / 100));
        if (total < 16.5)
            Result = "Denutrition ou famine";
        else if(total <= 18.5)
            Result = "Maigreur";
        else if(total <= 25)
            Result = "Corpulence normale";
        else if(total < 30)
            Result = "Surpoids";
        else if(total < 35)
            Result = "Obésité modérée";
        else if(total < 40)
            Result = "Obésité sévère";
        else
            Result = "Obésité morbide";
        displayPrice(Result, total);
    }

    private void displayPrice(String Result, float total) {
        TextView ResultTextView = (TextView) findViewById(R.id.result);
        ResultTextView.setText(Result);
        if (total < 16.5)
            ResultTextView.setBackgroundColor(Color.parseColor("#3F51B5"));
        else if(total <= 18.5)
            ResultTextView.setBackgroundColor(Color.parseColor("#2196F3"));
        else if(total <= 25)
            ResultTextView.setBackgroundColor(Color.parseColor("#8BC34A"));
        else if(total < 30)
            ResultTextView.setBackgroundColor(Color.parseColor("#FFC107"));
        else if(total < 35)
            ResultTextView.setBackgroundColor(Color.parseColor("#FF9800"));
        else if(total < 40)
            ResultTextView.setBackgroundColor(Color.parseColor("#FF5722"));
        else
            ResultTextView.setBackgroundColor(Color.parseColor("#F44336"));


    }
}

