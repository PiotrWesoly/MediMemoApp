package com.example.medimemo_main_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_calendar = (Button) findViewById(R.id.calendarBtn);
        Button btn_progress = (Button) findViewById(R.id.progressBtn);
        Button btn_settings = (Button) findViewById(R.id.settingsBtn);

        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startCalendar = new Intent(getApplicationContext(), Calendar.class);
                startActivity(startCalendar);
            }
        });

        btn_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startProgress = new Intent(getApplicationContext(), Progress.class);
                startActivity(startProgress);
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSettings = new Intent(getApplicationContext(), Settings.class);
                startActivity(startSettings);
            }
        });


    }
}
