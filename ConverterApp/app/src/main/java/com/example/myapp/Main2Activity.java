package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = (Button) findViewById(R.id.Display_button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //Getting values
                Intent caller = getIntent();
                String value = caller.getStringExtra("numValue");
                String unit = caller.getStringExtra("numUnit");
                EditText valueDisplay = (EditText) findViewById(R.id.valueDisplay);
                EditText unitDisplay = (EditText) findViewById(R.id.editText4);
                DecimalFormat decem = new DecimalFormat("0.00");

                if(unit.equals("Miles")){
                    double MilesConvertered = Double.valueOf(value);
                    double KmConvertered = MilesConvertered * 1.609;
                    valueDisplay.setText(decem.format(KmConvertered));
                    unitDisplay.setText("Kms");

                } else if(unit.equals("Kms")){
                    double KmConvertered = Double.valueOf(value);
                    double MilesConvertered = KmConvertered/1.609;
                    valueDisplay.setText(decem.format(MilesConvertered));
                    unitDisplay.setText("Miles");

                } else if(unit.equals("Pounds")){
                    double PoundsConvertered = Double.valueOf(value);
                    double KgConvertered = PoundsConvertered/2.205;
                    valueDisplay.setText(decem.format(KgConvertered));
                    unitDisplay.setText("Kgs");

                } else if(unit.equals("Kgs")){
                    double KgConvertered = Double.valueOf(value);
                    double PoundsConvertered = KgConvertered * 2.205;
                    valueDisplay.setText(decem.format(PoundsConvertered));
                    unitDisplay.setText("Pounds");

                } else if(unit.equals("Inches")){
                    double InchesConvertered = Double.valueOf(value);
                    double CmConvertered = InchesConvertered/2.54;
                    valueDisplay.setText(decem.format(CmConvertered));
                    unitDisplay.setText("Cms");

                } else if(unit.equals("Cms")){
                    double CmConvertered = Double.valueOf(value);
                    double InchesConvertered = CmConvertered * 2.54;
                    valueDisplay.setText(decem.format(InchesConvertered));
                    unitDisplay.setText("Inches");

                } else {
                    valueDisplay.setText("Unsupported unit: " + unit);
                }


            }
        });

        // setup return button
        Button button2 = (Button) findViewById(R.id.button_return);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent (Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
