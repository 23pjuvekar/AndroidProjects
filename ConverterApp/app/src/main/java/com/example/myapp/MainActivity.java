package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up for spinner
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Spinner1, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        //Set for confirm button action
        Button button = (Button) findViewById(R.id.confirm_button);
        button.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v){

                // get number entered
                EditText eNum = (EditText) findViewById(R.id.editText);
                String num = eNum.getText().toString();
                if ( num.isEmpty() ) {
                    num = "1"; // default to 1 if nothing entered
                }

                // get unit entered
                Spinner spinner = (Spinner) findViewById(R.id.spinner_1);
                String unit = spinner.getSelectedItem().toString();

                // pass num and value to Main2Activity
                Intent intent = new Intent (MainActivity.this, Main2Activity.class);
                intent.putExtra("numValue", num);
                intent.putExtra("numUnit", unit);
                startActivity(intent);
            }
        });


    }
}
