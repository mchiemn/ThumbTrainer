package com.example.thumbtrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultsText;
    Button restartButton;
    double counterResult, time, endResult;
    String resultString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
    }

    public void init(){
        resultsText = findViewById(R.id.resultText);
        restartButton = findViewById(R.id.GoAgainButton);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        //counterResult = GameActivity.getCounter();
       // time = MainActivity.getTime();
        endResult = GameActivity.getCounter() / MainActivity.getTime();
        resultString = String.format("%.2f", endResult);
        resultsText.setText(resultString);
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}