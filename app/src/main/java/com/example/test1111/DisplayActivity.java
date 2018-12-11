package com.example.test1111;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.test1111.database.History;
import com.example.test1111.database.MyDatabase;
import com.example.test1111.model.Constants;
import com.example.test1111.model.DAPreferences;

import java.util.ArrayList;

import static com.example.test1111.AfricanActivity.africaFoodArrayList;
import static com.example.test1111.Northamericaactivity.northAmericanList;


public class DisplayActivity extends AppCompatActivity {

    private TextView mtvName;
    private TextView mtvumber;
    private MyDatabase database;
    private ArrayList<History> arrayList;
    private TextView tv_lastOrder;
    private String getRestauranName = "";
    private String checkOutId = "";
    private String quantity = "1";
    private CardView reorderCardView;
    private boolean OrderAgain = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants_screen);

        //database Initialization
        database = new MyDatabase(this);

        // get List of users logged data or history
        arrayList = database.getLoginData();


        //  seding data from one class to another
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String number = intent.getStringExtra(MainActivity.EXTRA_NUMBER);
        OrderAgain = intent.getBooleanExtra(ThanksActivity.EXTRA_ORDER_AGAIN, true);

        mtvName = (TextView) findViewById(R.id.textView0);
        mtvumber = (TextView) findViewById(R.id.textView4);
        tv_lastOrder = (TextView) findViewById(R.id.textViewDetail);
        reorderCardView = (CardView) findViewById(R.id.reorder_cardview);

        // Setting Up TitleBar Name
        getSupportActionBar().setTitle("Restaurants");

        // Getting Value From SharedPrefernce File and Setting up on TextViews
        mtvName.setText(DAPreferences.readString(this, Constants.CustomerName));
        mtvumber.setText(DAPreferences.readString(this, Constants.CustomerMobile));

        // Method For Checking current user having last order
        checkForLastOrder();

    }

    /**
     * This method for getting database entries
     * and then check that current user have logged in befor or order something before
     * if he orders then there is dialog shows on bottom that do you want to reorder the last order
     * item again
     */
    private void checkForLastOrder() {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (DAPreferences.readString(this, Constants.CustomerMobile).equals(arrayList.get(i).getUserNumber())) {
                    if (arrayList.get(i).getItem_id() != null) {
                        getRestauranName = arrayList.get(i).getRestaurantName();
                        checkOutId = arrayList.get(i).getItem_id();
                        if (arrayList.get(i).getQuntity() != null)
                            quantity = arrayList.get(i).getQuntity();

                        //this will show the popup of reorder again otherwise on layout its visiblity is GONE
                        //if its comes from login page else if it comes from ThanksActivity then it will not show
                        //OrderAgain is Boolean value checks is it comes from ThanksActivity class if yes then its value is false
                        if (OrderAgain)
                            reorderCardView.setVisibility(View.VISIBLE);
                    }
                }
            }
            checkForWhichRestaurant(getRestauranName, checkOutId, quantity);

        }
    }

    public void sendtoafrica(View view) {
        Intent intent3 = new Intent(this, BookTableActivity.class);
        intent3.putExtra(Constants.resturantKey, Constants.Africa);
        startActivity(intent3);
    }

    public void sendtoasia(View view) {
        // Intent intent4 = new Intent(this, BookTableActivity.class);
        //intent4.putExtra(Constants.resturantKey, Constants.Asia);
        //startActivity(intent4);
    }

    public void sendtoeurope(View view) {
        //Intent intent5 = new Intent(this, BookTableActivity.class);
        //intent5.putExtra(Constants.resturantKey, Constants.Europe);
        //startActivity(intent5);
    }

    public void sendtonorthamerica(View view) {
        Intent intent6 = new Intent(this, BookTableActivity.class);
        intent6.putExtra(Constants.resturantKey, Constants.NorthAmerica);
        startActivity(intent6);
    }

    public void sendtosouthamerica(View view) {
        //Intent intent7 = new Intent(this, BookTableActivity.class);
        //intent7.putExtra(Constants.resturantKey, Constants.SouthAmerica);
        //startActivity(intent7);
    }

    /**
     * This method basically check that if users having previous order ,
     * so on which restaurant they have order previously
     */
    private void checkForWhichRestaurant(String whichRestaurant, String checkOutId, String quantity) {
        switch (whichRestaurant) {
            case Constants.Africa:
                AfricanActivity.addFoodData();
                tv_lastOrder.setText(africaFoodArrayList.get(Integer.parseInt(checkOutId)).getName() + " x " + quantity);
                break;
            case Constants.Asia:

                break;
            case Constants.NorthAmerica:
                Northamericaactivity.addFoodData();
                tv_lastOrder.setText(northAmericanList.get(Integer.parseInt(checkOutId)).getName() + " x " + quantity);
                break;
            case Constants.Europe:
                break;
            case Constants.SouthAmerica:

                break;

        }
    }

    /**
     * Reorder Dialog Button
     * if user clicks on reorder again then its directly sends to
     * CheckOut Activity
     */
    public void repeatOrder(View view) {
        startActivity(new Intent(this, CheckoutActivity.class).putExtra("id", Integer.parseInt(checkOutId)));
    }
}
