package com.example.medimemo_main_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Calendar extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    String st1;
    String st2;
    String st3;

   private Button button;

    ledControl LED = new ledControl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);





      button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpopup();

            }
        });
        tv1=findViewById((R.id.textView14));
        tv2=findViewById((R.id.textView13));
        tv3=findViewById((R.id.textView15));
//        st1= Objects.requireNonNull(getIntent().getExtras()).getString("Value1");
//        st2=getIntent().getExtras().getString("Value2");
//        st3=getIntent().getExtras().getString("Value3");

        tv1.setText(getIntent().getStringExtra("Value1"));
        tv2.setText(getIntent().getStringExtra("Value2"));
        tv3.setText(getIntent().getStringExtra("Value3"));
//        tv1.setText(st1);
//        tv2.setText(st2);
//        tv3.setText(st3);

    }

    public void openpopup(){
        Intent intent = new Intent(this,popup.class);
        startActivity(intent);
    }
    //ledControl LED = new ledControl();


}