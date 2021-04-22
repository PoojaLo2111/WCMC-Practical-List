package com.example.temprature_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1,editText2;
    private TextView result1,result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!editText1.getText().toString().equals("")){
                    float t1 = Integer.parseInt(editText1.getText().toString());
                    float ans1 = (t1-32)*5/9;
                    result1.setText(String.valueOf(ans1));
                }

                if(!editText2.getText().toString().equals("")){
                    float t2 = Integer.parseInt(editText2.getText().toString());
                    float ans2 = ((9*t2)/5)+32;
                    result2.setText(String.valueOf(ans2));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
    }
}