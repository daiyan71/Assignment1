package com.example.daiya.assignment1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button giveInfoButton;
    private Button seeInfoButton;
    AlertDialog.Builder alert;
    View view;
    Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=this.getWindow().getDecorView();

        button1=findViewById(R.id.colorButton1);
        button2=findViewById(R.id.colorButton2);
        button3=findViewById(R.id.colorButton3);
        button4=findViewById(R.id.colorButton4);
        giveInfoButton=findViewById(R.id.giveInfoButton);
        seeInfoButton=findViewById(R.id.seeInfoButton);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        giveInfoButton.setOnClickListener(this);
        seeInfoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.giveInfoButton)
        {
            Intent intent=new Intent(MainActivity.this,GiveInfo.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.seeInfoButton)
        {
            Intent intent=new Intent(MainActivity.this,ShowInfo.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.colorButton1)
        {
           // Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show();
            view.setBackgroundResource(R.color.red);
        }
        if(v.getId()==R.id.colorButton2)
        {
            view.setBackgroundResource(R.color.green);
        }
        if(v.getId()==R.id.colorButton3)
        {
            view.setBackgroundResource(R.color.yellow);
        }
        if(v.getId()==R.id.colorButton4)
        {
            view.setBackgroundResource(R.color.blue);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        alert =new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("ALERT TITLE");
        alert.setMessage("Do you want to exit?");
        alert.setIcon(R.drawable.alert);

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog=alert.create();
        alertDialog.show();


    }
}
