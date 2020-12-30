package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button milesToKms = (Button)findViewById(R.id.milesToKmsButton);
        milesToKms.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText milesText = (EditText) findViewById(R.id.milesText);
                EditText kmsText = (EditText) findViewById(R.id.kmsText);
                double vMiles = Double.valueOf(milesText.getText().toString());
                double vKm = vMiles/0.62137;
                DecimalFormat format = new DecimalFormat("0.00");
                kmsText.setText(format.format(vKm));
            }
        });
        Button kmsToMiles = (Button)findViewById(R.id.kmsToMilesButton);
        kmsToMiles.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText milesText = (EditText) findViewById(R.id.milesText);
                EditText kmsText = (EditText) findViewById(R.id.kmsText);
                double vKm = Double.valueOf(milesText.getText().toString());
                double vMiles = vKm * 0.62137;
                DecimalFormat format = new DecimalFormat("0.00");
                kmsText.setText(format.format(vMiles));
            }
        });
    }
}
