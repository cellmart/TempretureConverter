package com.johnson.tempretureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.inputvalue);
    }

    //create onclick method
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button1:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton fahrenheitButton = (RadioButton)findViewById(R.id.radio1);
                if (editText.getText().length() == 0){
                    Toast.makeText(this,"Please Enter Valid Number",Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(editText.getText().toString());
                if (celsiusButton.isChecked()){
                    editText.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else{
                    editText.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    celsiusButton.setChecked(true);
                    fahrenheitButton.setChecked(false);
                }
                break;
        }
    }
}
