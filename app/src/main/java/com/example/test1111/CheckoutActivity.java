package com.example.test1111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test1111.R;
import com.example.test1111.database.History;
import com.example.test1111.database.MyDatabase;
import com.example.test1111.model.Constants;
import com.example.test1111.model.DAPreferences;

import static com.example.test1111.DiningApp.africaFoodArrayList;
import static com.example.test1111.Northamericaactivity.northAmericanList;


public class CheckoutActivity extends AppCompatActivity {

    Intent intent;
    int id;
    TextView textViewName;
    TextView textViewPrice;
    TextView textViewTotalPrice;
    TextView textViewDescription;
    TextView textViewQuantity;
    TextView textViewTotalQuantity;
    ImageView imageViewProduct;
    int priceWithQuantity, actualPrice;
    private MyDatabase database;
    public String checkoutrice;
    public int quantity_count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        quantity_count = 1;
        database = new MyDatabase(this);

        getSupportActionBar().setTitle("Checkout");
        intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("id")) {
            id = intent.getExtras().getInt("id");
        }
        findView();
    }

    private void findView() {
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        textViewDescription = (TextView) findViewById(R.id.textViewDecription);
        textViewQuantity = (TextView) findViewById(R.id.quantity);
        textViewTotalQuantity = (TextView) findViewById(R.id.textViewTotalQuntity);
        imageViewProduct = (ImageView) findViewById(R.id.imageViewProduct);
        textViewTotalPrice = (TextView) findViewById(R.id.textViewTotalPrice);

        checkOrderFromWhichRestaurant();

        textViewTotalQuantity.setText(quantity_count + "");
        textViewQuantity.setText(quantity_count + "");

        priceWithQuantity = Integer.parseInt(checkoutrice.replaceAll("€", ""));
        actualPrice = Integer.parseInt(checkoutrice.replaceAll("€", ""));


    }

    private void checkOrderFromWhichRestaurant() {
        String restaurantName = DAPreferences.readString(this, Constants.SelectedRestaurant);

        switch (restaurantName) {

            case Constants.NorthAmerica:
                textViewName.setText(northAmericanList.get(id).getName());
                textViewPrice.setText(northAmericanList.get(id).getPrice());
                textViewDescription.setText(northAmericanList.get(id).getDescription());
                imageViewProduct.setImageResource(northAmericanList.get(id).getImage());
                textViewTotalPrice.setText(northAmericanList.get(id).getPrice());
                checkoutrice = northAmericanList.get(id).getPrice();

                break;
            case Constants.Africa:
                textViewName.setText(africaFoodArrayList.get(id).getName());
                textViewPrice.setText(africaFoodArrayList.get(id).getPrice());
                textViewDescription.setText(africaFoodArrayList.get(id).getDescription());
                imageViewProduct.setImageResource(africaFoodArrayList.get(id).getImage());
                textViewTotalPrice.setText(africaFoodArrayList.get(id).getPrice());
                checkoutrice = africaFoodArrayList.get(id).getPrice();

                break;
        }
    }

    public void decreaseQuantity(View view) {
        if (quantity_count > 1) {
            quantity_count--;
            textViewQuantity.setText(quantity_count + "");
            textViewTotalQuantity.setText(quantity_count + "");
            priceWithQuantity = priceWithQuantity - actualPrice;
            textViewTotalPrice.setText("€" + priceWithQuantity);

        }
    }

    public void increaseQuantity(View view) {
        quantity_count++;
        textViewQuantity.setText(quantity_count + "");
        textViewTotalQuantity.setText(quantity_count + "");
        priceWithQuantity = priceWithQuantity + actualPrice;
        textViewTotalPrice.setText("€" + priceWithQuantity);

    }


    public void checkOut(View view) {
        saveCheckoutInDB();
        DAPreferences.putString(this, Constants.CheckOutPrice, textViewTotalPrice.getText().toString().replaceAll("€", ""));
        startActivity(new Intent(this, ThanksActivity.class));
    }

    private void saveCheckoutInDB() {
        String mobileNumber = DAPreferences.readString(this, Constants.CustomerMobile);
        String RestaurantName = DAPreferences.readString(this, Constants.SelectedRestaurant);
        database.updateStatus(mobileNumber, RestaurantName, String.valueOf(id));
    }
}
