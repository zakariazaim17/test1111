package com.example.test1111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.test1111.model.Constants;
import com.example.test1111.model.DAPreferences;

public class ThanksActivity extends AppCompatActivity {

    TextView tv_name, tv_mobile, tv_seat, tv_price, tv_restaurant;
    public static final String EXTRA_ORDER_AGAIN = "com.example.task4_1.Order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);

        getSupportActionBar().setTitle("Table Check");


        initializeViews();
    }

    private void initializeViews() {
        tv_name = (TextView) findViewById(R.id.name);
        tv_mobile = (TextView) findViewById(R.id.phone_number);
        tv_seat = (TextView) findViewById(R.id.seats);
        tv_price = (TextView) findViewById(R.id.total_price);
        tv_restaurant = (TextView) findViewById(R.id.restaurantName);

        //Setting Text On Views Using Shared Preference
        tv_name.setText(DAPreferences.readString(this, Constants.CustomerName));
        tv_mobile.setText(DAPreferences.readString(this, Constants.CustomerMobile));
        tv_seat.setText(DAPreferences.readString(this, Constants.SeatsBook));
        tv_price.setText(DAPreferences.readString(this, Constants.CheckOutPrice));
        tv_restaurant.setText(DAPreferences.readString(this, Constants.SelectedRestaurant));
    }

    /**
     *  Button Click which sends to back on Restaurants
     */
    public void backToHome(View view) {
        startActivity(new Intent(this, MainActivity.class).putExtra(EXTRA_ORDER_AGAIN, false));
    }
}
