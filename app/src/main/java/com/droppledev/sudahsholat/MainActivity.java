package com.droppledev.sudahsholat;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb_shubuh;
    private CheckBox cb_dhuhur;
    private CheckBox cb_ashar;
    private CheckBox cb_maghrib;
    private CheckBox cb_isya;
    private Button btn_save, btn_reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_shubuh = (CheckBox) findViewById(R.id.cb_shubuh);
        cb_dhuhur = (CheckBox) findViewById(R.id.cb_dhuhur);
        cb_ashar = (CheckBox) findViewById(R.id.cb_ashar);
        cb_maghrib = (CheckBox) findViewById(R.id.cb_maghrib);
        cb_isya = (CheckBox) findViewById(R.id.cb_isya);
        btn_reset = (Button) findViewById(R.id.btn_reset);

        // Toolbar sebagai action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String shubuh,dhuhur,ashar,maghrib,isya,state;
        final SharedPreferences sharedPreferences = getSharedPreferences("save",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        // Cek pertama kali buka aplikasi
        shubuh = sharedPreferences.getString("shubuh","");
        dhuhur = sharedPreferences.getString("dhuhur","");
        ashar = sharedPreferences.getString("ashar","");
        maghrib = sharedPreferences.getString("maghrib","");
        isya = sharedPreferences.getString("isya","");
        state = sharedPreferences.getString("state","");

        if(shubuh.equals("1")){
            cb_shubuh.setChecked(true);
        }
        if(dhuhur.equals("1")){
            cb_dhuhur.setChecked(true);
        }
        if(ashar.equals("1")){
            cb_ashar.setChecked(true);
        }
        if(maghrib.equals("1")){
            cb_maghrib.setChecked(true);
        }
        if(isya.equals("1")){
            cb_isya.setChecked(true);
        }
        if (state.equals("1")){
            Toast.makeText(MainActivity.this, "Selamat datang kembali !",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Selamat datang !",Toast.LENGTH_SHORT).show();
        }
        editor.putString("state","1");
        editor.apply();

        // Pertama kali buka selesai

        // Saat Checkbox di klik

        cb_shubuh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(cb_shubuh.isChecked()){
                    String shubuh ="1";
                    editor.putString("shubuh",shubuh);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda sudah melaksanakan Sholat Shubuh",Toast.LENGTH_SHORT).show();
                }
                else{
                    String shubuh ="";
                    editor.putString("shubuh",shubuh);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda belum melaksanakan Sholat Shubuh",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb_dhuhur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(cb_dhuhur.isChecked()){
                    String dhuhur ="1";
                    editor.putString("dhuhur",dhuhur);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda sudah melaksanakan Sholat Dhuhur",Toast.LENGTH_SHORT).show();
                }
                else{
                    String dhuhur ="";
                    editor.putString("dhuhur",dhuhur);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda belum melaksanakan Sholat Dhuhur",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb_ashar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(cb_ashar.isChecked()){
                    String ashar ="1";
                    editor.putString("ashar",ashar);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda sudah melaksanakan Sholat Ashar",Toast.LENGTH_SHORT).show();
                }
                else{
                    String ashar ="";
                    editor.putString("ashar",ashar);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda belum melaksanakan Sholat Ashar",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb_maghrib.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(cb_maghrib.isChecked()){
                    String maghrib ="1";
                    editor.putString("maghrib",maghrib);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda sudah melaksanakan Sholat Maghrib",Toast.LENGTH_SHORT).show();
                }
                else{
                    String maghrib ="";
                    editor.putString("maghrib",maghrib);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda belum melaksanakan Sholat Maghrib",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb_isya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(cb_isya.isChecked()){
                    String isya ="1";
                    editor.putString("isya",isya);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda sudah melaksanakan Sholat Isya",Toast.LENGTH_SHORT).show();
                }
                else{
                    String isya ="";
                    editor.putString("isya",isya);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Anda belum melaksanakan Sholat Isya",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Checkbox klik selesai
    }

    // Action Bar Properties

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // pembuatan action bar
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) { // saat button di action bar di klik, berdasarkan item id
            case R.id.btn_reset: // saat btn_reset di klik

                    String shubuh,dhuhur,ashar,maghrib,isya;

                    SharedPreferences sharedPreferences = getSharedPreferences("save",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    shubuh ="";
                    editor.putString("shubuh",shubuh);
                    dhuhur ="";
                    editor.putString("dhuhur",dhuhur);
                    ashar ="";
                    editor.putString("ashar",ashar);
                    maghrib ="";
                    editor.putString("maghrib",maghrib);
                    isya ="";
                    editor.putString("isya",isya);

                    if(cb_shubuh.isChecked()){
                        cb_shubuh.setChecked(false);
                    }
                    if(cb_dhuhur.isChecked()){
                        cb_dhuhur.setChecked(false);
                    }
                    if(cb_ashar.isChecked()){
                        cb_ashar.setChecked(false);
                    }
                    if(cb_maghrib.isChecked()){
                        cb_maghrib.setChecked(false);
                    }
                    if(cb_isya.isChecked()){
                        cb_isya.setChecked(false);
                    }
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Reset",Toast.LENGTH_LONG).show();
            return(true);
        }
        return(super.onOptionsItemSelected(item));
    }
}

