package com.example.massacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class act_calculator extends AppCompatActivity {

    RadioGroup Pol;
    RadioButton Male, Female;
    EditText Weight, Height;
    Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_calculator);

        Pol = (RadioGroup) findViewById(R.id.rgPol);
        Male = (RadioButton) findViewById(R.id.rbM);
        Female = (RadioButton) findViewById(R.id.rbF);
        Weight = (EditText) findViewById(R.id.etWeight);
        Height = (EditText) findViewById(R.id.etHeight);
        Calculate = (Button) findViewById(R.id.btnCalculate);

        View.OnClickListener onCalculateClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h = Height.getText().toString();
                String w = Weight.getText().toString();


                if (isInputValid(h) && isInputValid(w)) {
                    double doubleH = Double.parseDouble(h);
                    double doubleW = Double.parseDouble(w);

                    double massaIndex = doubleW / (doubleH * doubleH / 10000);

                    if (Pol.getCheckedRadioButtonId() == -1) {

                    } else {

                        if (Male.isChecked()) {
                            Toast.makeText(getApplicationContext(), "Первый элемент нажат",
                                    Toast.LENGTH_LONG).show();
                        } else if (Female.isChecked()) {
                            Toast.makeText(getApplicationContext(), "Второй элемент нажат",
                                    Toast.LENGTH_LONG).show();
                        }


                    }

                    if (massaIndex < 16)
                        Toast.makeText(getApplicationContext(), "Выраженный дефицит массы",
                                Toast.LENGTH_SHORT).show();

                    if (massaIndex >= 16 && massaIndex < 18.5)
                        Toast.makeText(getApplicationContext(), "Дефицит массы",
                                Toast.LENGTH_SHORT).show();

                    if (massaIndex >= 18.5 && massaIndex < 25)
                        Toast.makeText(getApplicationContext(), "Нормальная масса",
                                Toast.LENGTH_SHORT).show();

                    if (massaIndex >= 25 && massaIndex < 30)
                        Toast.makeText(getApplicationContext(), "Предожирение",
                                Toast.LENGTH_SHORT).show();

                    if (massaIndex >= 30 && massaIndex < 40)
                        Toast.makeText(getApplicationContext(), "Ожирение",
                                Toast.LENGTH_SHORT).show();

                    if (massaIndex > 40)
                        Toast.makeText(getApplicationContext(), "Труп",
                                Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Некорректные данные",
                            Toast.LENGTH_SHORT).show();
            }
        };


        Calculate.setOnClickListener(onCalculateClickListener);
    }

    public boolean isInputValid(String inputData) {
        try {
            double d = Double.parseDouble(inputData);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
