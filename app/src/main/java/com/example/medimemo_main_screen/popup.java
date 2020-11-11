package com.example.medimemo_main_screen;

import com.example.medimemo_main_screen.ledControl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Timer;
import java.util.TimerTask;

public class popup extends AppCompatActivity {

    String st1;
    String st2;
    String st3;
    Spinner SPT1;
    Spinner SPT2;
    Spinner SPT3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        SPT1 = (Spinner) findViewById(R.id.sp2);
        SPT2 = (Spinner) findViewById(R.id.sp3);
        SPT3 = (Spinner) findViewById(R.id.sp4);
        button = (Button) findViewById(R.id.button3);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(popup.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        ArrayAdapter<String> time1 = new ArrayAdapter<String>(popup.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time));
        time1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SPT1.setAdapter(time1);

        SPT2.setAdapter(time1);

        SPT3.setAdapter(time1);

        final ledControl LED = new ledControl();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(popup.this, Calendar.class);
                st1 = SPT1.getSelectedItem().toString();
                st2 = SPT2.getSelectedItem().toString();
                st3 = SPT3.getSelectedItem().toString();
                Intent value1 = i.putExtra("Value1", st1);
                Intent value2 = i.putExtra("Value2", st2);
                Intent value3 = i.putExtra("Value3", st3);
                LED.start(v);
                startActivity(i);
                finish();

            }
        });


    }


}