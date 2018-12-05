package com.example.test1111;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.test1111.MainActivity.EXTRA_NUMBER;

public class Africanactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_africanactivity);


    }
    public void sendthis(View view) {

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);

        int number2 = Integer.parseInt(editText3.getText().toString());
        int number3 = Integer.parseInt(editText4.getText().toString());


        if (number2 <= 14 && number3 <= 5) {
            Intent intent = new Intent(this, MealAfrica.class);
            intent.putExtra(EXTRA_NUMBER, number2);
            intent.putExtra(EXTRA_NUMBER, number3);
            startActivity(intent);
        } else {


            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setMessage("Please check if your desired seats/tables are available")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setTitle("Notice")
                    .create();
            myAlert.show();

        }
    }
}
