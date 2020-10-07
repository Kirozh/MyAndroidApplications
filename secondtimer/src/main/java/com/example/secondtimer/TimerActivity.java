package com.example.secondtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    Button startBtn, stopBtn, restartBtn;
    Chronometer Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        restartBtn = (Button) findViewById(R.id.restartBtn);
        Timer = (Chronometer) findViewById(R.id.crTime);

        View.OnClickListener onStartClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Timer.start();
            }
        };

        View.OnClickListener onStopClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer.stop();
            }
        };

        View.OnClickListener onRestartClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer.setBase(SystemClock.elapsedRealtime());
            }
        };

        startBtn.setOnClickListener(onStartClickListener);
        stopBtn.setOnClickListener(onStopClickListener);
        restartBtn.setOnClickListener(onRestartClickListener);
    }


}
