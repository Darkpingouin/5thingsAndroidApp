package com.example.android.a5things;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
            switch (view.getId()) {
                case (R.id.Button_1):
                    Intent intent = new Intent(this, Main2Activity.class);
                    startActivity(intent);
                    break;
                case (R.id.Button_2):
                    Intent intent2 = new Intent(this, Main3Activity.class);
                    startActivity(intent2);
                    break;
                case (R.id.Button_3):
                    Intent intent3 = new Intent(this, Main4Activity.class);
                    startActivity(intent3);
                    break;
                case (R.id.Button_4):
                    Intent intent4 = new Intent(this, Main6Activity.class);
                    startActivity(intent4);
                    break;
                case (R.id.Button_5):
                    Intent intent5 = new Intent(this, Main5Activity.class);
                    startActivity(intent5);
                    break;
            }
    }

}
