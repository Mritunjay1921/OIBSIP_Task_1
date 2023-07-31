package com.mritunjay.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

     EditText editTextWeight;
     RadioGroup radioGroupWeight;
     RadioGroup radioGroupType;
     TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        radioGroupWeight = findViewById(R.id.radioGroup);
        radioGroupType = findViewById(R.id.radioGroupType);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void convertWeight(View view) {
        String weightString = editTextWeight.getText().toString().trim();
        if (weightString.isEmpty()) {
            textViewResult.setText("Please enter a weight value.");
            return;
        }

        double weight = Double.parseDouble(weightString);
        int selectedWeight = radioGroupWeight.getCheckedRadioButtonId();
        int selectedType = radioGroupType.getCheckedRadioButtonId();

        if (selectedWeight == R.id.radioButtonPounds) {
            if (selectedType == R.id.radioButtonToKilograms) {
                double kilograms = weight * 0.45359237;
                textViewResult.setText(String.format("%.2f kilograms", kilograms));
            } else if (selectedType == R.id.radioButtonToGrams) {
                double grams = weight * 453.59237;
                textViewResult.setText(String.format("%.2f grams", grams));
            } else {
                textViewResult.setText("Please select a conversion type.");
            }
        } else if (selectedWeight == R.id.radioButtonKilograms) {
            if (selectedType == R.id.radioButtonToPounds) {
                double pounds = weight / 0.45359237;
                textViewResult.setText(String.format("%.2f pounds", pounds));
            } else if (selectedType == R.id.radioButtonToGrams) {
                double grams = weight * 1000;
                textViewResult.setText(String.format("%.2f grams", grams));
            } else {
                textViewResult.setText("Please select a conversion type.");
            }
        } else if (selectedWeight == R.id.radioButtonGrams) {
            if (selectedType == R.id.radioButtonToPounds) {
                double pounds = weight / 453.59237;
                textViewResult.setText(String.format("%.2f pounds", pounds));
            } else if (selectedType == R.id.radioButtonToKilograms) {
                double kilograms = weight / 1000;
                textViewResult.setText(String.format("%.2f kilograms", kilograms));
            } else {
                textViewResult.setText("Please select a conversion type.");
            }
        } else {
            textViewResult.setText("Please select a weight unit.");
        }
    }
}
