package com.example.daiya.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ShowInfo extends AppCompatActivity implements View.OnClickListener {
    TextView seekTextView,ratingTextView,checkTextView,radioTextView;
    SeekBar seekbar;
    RadioGroup radioGroup;
    RadioButton radioButton1,radioButton2;
    CheckBox checkBox1,checkBox2,checkBox3;
    RatingBar ratingBar;
    Button showButton,viewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        seekTextView=findViewById(R.id.seekTextView);
        checkTextView=findViewById(R.id.checkTextView);
        radioTextView=findViewById(R.id.radioTextView);
        ratingTextView=findViewById(R.id.ratingTextView);
        seekbar=findViewById(R.id.seekbarId);
        ratingBar=findViewById(R.id.ratingBarId);
        checkBox1=findViewById(R.id.checkBoxId1);
        checkBox2=findViewById(R.id.checkBoxId2);
        checkBox3=findViewById(R.id.checkBoxId3);
        radioButton1=findViewById(R.id.radioButtonID1);
        radioButton2=findViewById(R.id.radioButtonID2);
        radioGroup=findViewById(R.id.radioGroupId);
        showButton=findViewById(R.id.showId);
        viewButton=findViewById(R.id.viewId);

        seekTextView.setText("Volume :"+seekbar.getProgress());
        ratingTextView.setText("Rating :"+ratingBar.getProgress());

        showButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekTextView.setText("Volume :"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingTextView.setText("Rating :"+rating);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.showId)
        {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            int id=radioGroup.getCheckedRadioButtonId();
            radioButton1=findViewById(id);
            String value=radioButton1.getText().toString();
            radioTextView.setText(value);
        }

        if(v.getId()==R.id.viewId)
        {
            StringBuilder string =new StringBuilder();
            if(checkBox1.isChecked())
            {
                String value =checkBox1.getText().toString();
                string.append((value+","));
            }
            if(checkBox2.isChecked())
            {
                String value =checkBox2.getText().toString();
                string.append((value+","));
            }
            if(checkBox3.isChecked())
            {
                String value =checkBox3.getText().toString();
                string.append((value+","));
            }
            checkTextView.setText(string);
        }

        }
}
