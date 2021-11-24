package com.example.tempconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {

    private EditText text;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editTextNumberDecimal);
    }

    /* this method is called when user clicks the button and is handled
    because we assigned the name to the "OnClick property" of the
    button */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button5:
                RadioButton celsiusButton =
                        findViewById(R.id.radioButton);
                RadioButton fahrenheitButton =
                        findViewById(R.id.radioButton2);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue =
                        Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else {
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                //grab CURRENT result value now in Text Field
                inputValue = Float.parseFloat(text.getText().toString());
                view = findViewById(R.id.activity_main);
                if (inputValue > 90) {
                    //set hex color to skyblue
                    view.setBackgroundColor(Color.parseColor("#87ceff"));
                }
               else {
                        view.setBackgroundColor(Color.YELLOW);
                    }
                if (inputValue < 0) {
                    //set hex color to red
                    view.setBackgroundColor(Color.parseColor("#880808"));
                }

                    break;
                }
        }
    }

