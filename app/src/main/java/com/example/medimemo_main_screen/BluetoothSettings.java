package com.example.medimemo_main_screen;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckB Ihavox;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medimemo_main_screen.R;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothSettings extends AppCompatActivity {


    CheckBox enable_bt, visible_bt;
    TextView search_bt;
    TextView nam
    ListView list_view;
    //  Button change_screen;


    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    public static String EXTRA_ADDRESS = "device_address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_settings);


        enable_bt = findViewById(R.id.enable_bt);
        visible_bt = findViewById(R.id.visible_bt);
        search_bt = findViewById(R.id.search_bt);
        name_bt = findViewById(R.id.name_bt);
        list_view = findViewById(R.id.list_view);
        // change_screen = findViewById(R.id.change_screen);

        name_bt.setText(getLocalBluetoothName());

        BA = BluetoothAdapter.getDefaultAdapter();

        if (BA == null){
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (BA.isEnabled()){
            enable_bt.setChecked(true);
            Log.d("Co", "co");
        }
        enable_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    BA.disable();
                    Toast.makeText(BluetoothSettings.this, "Turned off", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intentOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intentOn,0);
                    Toast.makeText(BluetoothSettings.this, "Turned on", Toast.LENGTH_SHORT).show();
                }
            }
        });



        visible_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(getVisible, 0 );
                    Toast.makeText(BluetoothSettings.this, "Visible for 2 min", Toast.LENGTH_SHORT).show();
                }
            }
        });

        search_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                list();
            }
        });
    }

    private void list() {
        pairedDevices = BA.getBondedDevices();

        ArrayList list = new ArrayList();

        for ( BluetoothDevice bt : pairedDevices) {
            list.add(bt.getName() + "\n" + bt.getAddress());
        }

        Toast.makeText(this, "Showing Devices", Toast.LENGTH_SHORT).show();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        list_view.setAdapter(adapter);
        Log.d("Cosk", "COS");
        list_view.setOnItemClickListener(myListClickListener);

    }



    public String getLocalBluetoothName (){
        if(BA == null){
            BA = BluetoothAdapter.getDefaultAdapter();
        }
        String name = BA.getName();
        if (name == null) {
            name = BA.getAddress();
        }
        return name;
    }
    private AdapterView.OnItemClickListener myListClickListener = new AdapterView.OnItemClickListener()
    {
        public void onItemClick (AdapterView av, View v, int arg2, long arg3)
        {
            // Get the device MAC address, the last 17 chars in the View
            String info = ((TextView) v).getText().toString();
            // String address = info.substring(info.length() - 17 );
            String address = "00:11:35:97:95:98";
            // Make an intent to start next activity.
            Intent i = new Intent(BluetoothSettings.this, com.example.medimemo_main_screen.ledControl.class);
            //Change the activity.
            i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
            Log.d("Cokolwiek", "cokolwiek");
            startActivity(i);
        }
    };

}
