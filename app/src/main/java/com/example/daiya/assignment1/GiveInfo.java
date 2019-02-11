package com.example.daiya.assignment1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class GiveInfo extends AppCompatActivity implements View.OnClickListener {

    private DatePickerDialog datePickerDialog;
    private TextView textview,timeTextView,nameTextView;
    private EditText editname;
    private Button button,done,birthTime;
    private TimePickerDialog timePickerDialog;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_info);

        button=findViewById(R.id.setBirthDateButton);
        textview=findViewById(R.id.dateTextView);
        timeTextView=findViewById(R.id.timeTextView);
        editname=findViewById(R.id.editNameTextView);
        nameTextView=findViewById(R.id.nameTextView);
        done=findViewById(R.id.doneButton);
        birthTime=findViewById(R.id.setBirthTimeButton);

        birthTime.setOnClickListener(this);
        button.setOnClickListener(this);
        done.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.setBirthDateButton)
        {

            DatePicker datePicker = new DatePicker(this);
             int currentYear=datePicker.getYear();
             int currentMonth=(datePicker.getMonth())+1;
             int currentDay=datePicker.getDayOfMonth();

            datePickerDialog = new DatePickerDialog(GiveInfo.this,

                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            textview.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        }
                    },currentYear,currentMonth,currentDay);
            datePickerDialog.show();
        }
        if(v.getId()==R.id.doneButton)
        {
            String name;
            Toast.makeText(this, "DONE!", Toast.LENGTH_SHORT).show();
            name=editname.getText().toString();
            nameTextView.setText("NAME:"+name);
        }


        if(v.getId()==R.id.setBirthTimeButton)
        {
           // timeTextView.setText("aa");
            TimePicker timePicker=new TimePicker(this);

            int currentHour=timePicker.getCurrentHour();
            int currentMinute=timePicker.getCurrentMinute();
            timePickerDialog = new TimePickerDialog(GiveInfo.this,

                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            timeTextView.setText(hourOfDay+":"+minute);

                        }
                    }

            ,currentHour,currentMinute,true);
            timePickerDialog.show();
        }

    }
}
