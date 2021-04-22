package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private TextView result;
    private Button close;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.button);
        result = findViewById(R.id.result);
        close = findViewById(R.id.close);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String pass = password.getText().toString();

                if(username.equals("pooja") && pass.equals("1234")){
                    result.setText("Successful Login");
                    result.setBackgroundColor(0xFF8BC34A);
                }
                else {
                    i++;
                    result.setText("Unsuccessful Login");
                    result.setBackgroundColor(0xFFFF1100);
                }
                if(i==3){
                    login.setEnabled(false);
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }
}