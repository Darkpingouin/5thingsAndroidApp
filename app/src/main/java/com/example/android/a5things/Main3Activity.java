package com.example.android.a5things;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

import static java.lang.Math.round;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void goBack(View view) {
        this.finish();
    }
    public void info(View view)
    {
        Intent intent = new Intent(this, info.class);
        startActivity(intent);
    }
    public void calculate(View view) throws ParseException {
        EditText alcool = (EditText) findViewById(R.id.alcool);
        EditText poids = (EditText) findViewById(R.id.poids);
        RadioButton f = (RadioButton) findViewById(R.id.Femme);
        RadioButton h = (RadioButton) findViewById(R.id.Homme);
        String SAlcool = alcool.getText().toString();
        String SPoids = poids.getText().toString();
        String Result1;
        String Result2;
        float indice = 0;
        float heure = 0;
        float total = 0;
        float fAlcool = 0;
        float fPoids = 0;
        float div = 0;
        if (f.isChecked()) {
            indice = (float) 0.6;
            div = (float) 0.10;
        }
        else if (h.isChecked()) {
            indice = (float) 0.7;
            div = (float) 0.15;
        }
        else {
            Toast.makeText(this, "Vous n'avez pas entré votre sexe", Toast.LENGTH_SHORT).show();
            return;
        }
        if (SPoids.matches("")) {
            Toast.makeText(this, "Vous n'avez pas entré votre poids", Toast.LENGTH_SHORT).show();
            return;
        } else
            fPoids = Float.valueOf(SPoids);
        if (SAlcool.matches("")) {
            Toast.makeText(this, "Vous n'avez pas entré votre taux d'alcool", Toast.LENGTH_SHORT).show();
            return;
        } else
            fAlcool = Float.valueOf(SAlcool);
        total = round (fAlcool / (fPoids * indice) * 100);
        total /= 100;
        Result1 = "Votre taux d'alcoolémie est de: " + total;
        heure = (float) round ((total / div) * 100);
        heure /= 100;
        int hours = (int) heure;
        int minutes = (int) (60 * (heure - hours));
        Result2 = "Il vous faudra attendre " + hours + " h " + minutes  + " m pour tout éliminer";
        displayInfo(Result1, Result2, total);
    }
    private void displayInfo(String Result1, String Result2, float total) {
        TextView ResultTextView = (TextView) findViewById(R.id.taux);
        ResultTextView.setText(Result1);
        TextView ResultTextView2 = (TextView) findViewById(R.id.heure);
        ResultTextView2.setText(Result2);
        if (total <= 0.5)
            ResultTextView.setBackgroundColor(Color.parseColor("#4CAF50"));
        else if(total <= 0.8)
            ResultTextView.setBackgroundColor(Color.parseColor("#FF9800"));
        else
            ResultTextView.setBackgroundColor(Color.parseColor("#F44336"));
    }
}
