package com.example.test1111;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.test1111.model.Constants;
import com.example.test1111.model.DAPreferences;
import com.example.test1111.model.NorthAmericaFood;

import java.util.ArrayList;

public class BookTableActivity extends AppCompatActivity {

    Intent intent;
    String whichRestaurant;
    public static ArrayList<NorthAmericaFood> foodItemBeenList;
    public int table_book;
    public int seats_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_table);

        //setting Title for this Screen
        getSupportActionBar().setTitle("Book Table");

        //Getting Value that which Restaurant is clicked and we have to save it in Shared Prefernce File(Used For local Storage)
        intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.resturantKey)) {
            whichRestaurant = intent.getExtras().getString(Constants.resturantKey);
            DAPreferences.putString(this, Constants.SelectedRestaurant, whichRestaurant);
        }

    }

    public void sendthis(View view) {

        EditText editTextSeats = (EditText) findViewById(R.id.editText3);
        EditText editetTextTable = (EditText) findViewById(R.id.editText4);

        seats_book = Integer.parseInt(editTextSeats.getText().toString());
        table_book = Integer.parseInt(editetTextTable.getText().toString());

        DAPreferences.putString(this, Constants.SeatsBook, editTextSeats.getText().toString());


        if (seats_book==0 && table_book==0)
            showAlertDialog();
         else if(seats_book>14 && table_book>5) {
            showAlertDialog();
        }
        else if(table_book>5 || seats_book>14 ) {
            showAlertDialog();
        }else {

            checkForWhichRestaurant();
        }
    }

    private void showAlertDialog() {
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

    /**
     * This method check which restaurant clicked last and send it to according this restaurant
     * menu items
     */
    private void checkForWhichRestaurant() {
        switch (whichRestaurant) {
            case Constants.Africa:
                startActivity(new Intent(this, AfricanActivity.class));
                break;
            case Constants.Asia:
                startActivity(new Intent(this, Asianactivity.class));
                break;
            case Constants.NorthAmerica:
                startActivity(new Intent(this, Northamericaactivity.class));
                break;
            case Constants.Europe:
                startActivity(new Intent(this, Europianactivity.class));
                break;
            case Constants.SouthAmerica:
                startActivity(new Intent(this, Southamericaacivity.class));
                break;

        }
    }
}
