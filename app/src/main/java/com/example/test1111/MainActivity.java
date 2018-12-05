package com.example.test1111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.task4_1.Message";
    public static final String EXTRA_NUMBER ="com.example.task4_1.number";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View vew){

        EditText editText =(EditText) findViewById(R.id.editText);
        EditText editText1=(EditText) findViewById(R.id.editText2);
        String  message = editText.getText().toString();
        int number = Integer.parseInt(editText1.getText().toString());
        Intent intent =new Intent(this, DisplayActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_NUMBER,number );
        startActivity(intent);


    }
}
