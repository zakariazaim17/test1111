package com.example.test1111;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
}
