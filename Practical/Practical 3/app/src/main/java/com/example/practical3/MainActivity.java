package com.example.practical3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Object;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Toast toast;
    private Button start;
    private Button date1;
    private Button date2;
    private Button diff;
    private TextView result;
    DatePickerDialog.OnDateSetListener dateSetListener1,dateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start = findViewById(R.id.button1);

        /*toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.show();
                    }
                    },1000);*/

        Toast toast = Toast.makeText(this,"hello",Toast.LENGTH_SHORT);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0 ; i<1000 ; i++){
                    try {
                        Thread.sleep(1000);
                        toast.show();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        date1 = findViewById(R.id.date1);
        date2 = findViewById(R.id.date2);
        diff = findViewById(R.id.diff);
        result = findViewById(R.id.result);

        int year=0,month=0,day = 0;

        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener1,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        dateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                date1.setText(date);
            }
        };

        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener2,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                date2.setText(date);
            }
        };

        diff.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String d1 = date1.getText().toString();
                String d2 = date2.getText().toString();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/mm/yyyy");
                try {
                    Date date1 = simpleDateFormat1.parse(d1);
                    Date date2 = simpleDateFormat1.parse(d2);
                    long sdate = date1.getTime();
                    long edate = date2.getTime();

                    if(sdate<=edate){
                        Period period = new Period(sdate,edate,PeriodType.yearMonthDay());
                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();

                        result.setText(years+" Years |"+ months+" Months |"+days+" Days ");
                    }else {
                        result.setText("Not valid");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
