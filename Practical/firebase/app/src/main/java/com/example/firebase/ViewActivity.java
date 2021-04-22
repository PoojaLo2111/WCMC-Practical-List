package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;

public class ViewActivity extends AppCompatActivity {

    private EditText Name,Phonenumber,Email;
    private Button add;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Name = findViewById(R.id.Name);
        Phonenumber = findViewById(R.id.PhoneNumber);
        Email = findViewById(R.id.Email);
        add = findViewById(R.id.add);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }
    private void addData(){
        String name = Name.getText().toString();
        String phonenumber = Phonenumber.getText().toString();
        String email = Email.getText().toString();

        Info info = new Info(name,phonenumber,email);

        databaseReference.push().setValue(info);
        Toast.makeText(ViewActivity.this,"Data is inserted",Toast.LENGTH_LONG).show();
    }
}