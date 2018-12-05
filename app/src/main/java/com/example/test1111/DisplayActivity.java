package com.example.test1111;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class DisplayActivity extends AppCompatActivity {

  TextView showtext1;
  TextView showtext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);
         showtext1 = findViewById(R.id.textView0);
         showtext2 = findViewById(R.id.textView4);

       showtext1.setText(message);
       showtext2.setText("" + number);

       

    }
    public void sendtoafrica(View view){
        Intent intent3 =new Intent(this,Africanactivity.class);
        startActivity(intent3);
    }
    public void sendtoasia(View view){
        Intent intent4 =new Intent(this,Asianactivity.class);
        startActivity(intent4);
    }
    public void sendtoeurope(View view){
        Intent intent5 =new Intent(this,Europianactivity.class);
        startActivity(intent5);
    }
    public void sendtonorthamerica(View view){
        Intent intent6 =new Intent(this,Northamericaactivity.class);
        startActivity(intent6);
    }
    public void sendtosouthamerica(View view){
        Intent intent7 =new Intent(this,Southamericaacivity.class);
        startActivity(intent7);
    }
}
