package com.example.thumbtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner timeSelectSpinner;
    Button startButton;
    static double time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void init() {
        timeSelectSpinner = findViewById(R.id.TimeSpinner);
        startButton = findViewById(R.id.StartButton);

        Double[] times = new Double[]{10.0,20.0,30.0};
        ArrayAdapter<Double> adapter = new ArrayAdapter<Double>(this, android.R.layout.simple_spinner_item,times);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSelectSpinner.setAdapter(adapter);
        timeSelectSpinner.setOnItemSelectedListener(this);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameActivity();
            }
        });
    }
    public void openGameActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        time = (double) adapterView.getItemAtPosition(pos);
        String timeSet = "Test set to " + time + " seconds.";
        Toast.makeText(MainActivity.this, timeSet, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static double getTime() {
        return time;
    }
}