package com.example.thumbtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    ImageButton gameTarget;
    static double counter = 0;
    int xPosition, yPosition;
    MediaPlayer pew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        init();
    }

    public void init(){
        gameTarget = findViewById(R.id.gameTarget);
        double timer = MainActivity.getTime();
        xPosition = new Random().nextInt((900-4) + 1) + 4;
        yPosition = new Random().nextInt((1800-4) + 1) + 4;
        gameTarget.setX(xPosition);
        gameTarget.setY(yPosition);

        gameTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                stopAudio();
                pew = MediaPlayer.create(GameActivity.this, R.raw.silenced_pistol);
                pew.start();
                reposition();
            }
        });

        CountDownTimer gameTimer = new CountDownTimer((long) (timer * 1000), 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        }.start();

    }

    public void reposition(){
        xPosition = new Random().nextInt((900-4) + 1) + 4;
        yPosition = new Random().nextInt((1800-4) + 1) + 4;
        gameTarget.setX(xPosition);
        gameTarget.setY(yPosition);
    }
    public void stopAudio() {
        if (pew != null) {
            pew.stop();
            pew.release();
            pew = null;
        }
    }

    public static double getCounter(){
        return counter;
    }

}
