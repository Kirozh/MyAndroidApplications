package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    Button enterBtn;
    Button regBtn;
    TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterBtn = (Button) findViewById(R.id.Enter);
        enterBtn.setText("Войти");

        regBtn = (Button) findViewById(R.id.Registrate);
        regBtn.setText("Зарегистрироваться");

        enterBtn.setOnClickListener(this);
        regBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // по id определяем кнопку, вызвавшую этот обработчик
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        switch (v.getId()) {
            case R.id.Enter:
                // кнопка ОК
                Log.d(TAG, "кнопка Войти");
                //tvOut.setText("Нажата кнопка Войти");
                Toast.makeText(this, "Нажата кнопка Войти", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Registrate:
                // кнопка Cancel
                Log.d(TAG, "кнопка Зарегистрироваться");
                //tvOut.setText("Нажата кнопка Зарегистрироваться");
                Toast.makeText(this, "Нажата кнопка Зарегистрироваться",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
