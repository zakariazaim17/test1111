package com.example.test1111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test1111.database.History;
import com.example.test1111.database.MyDatabase;
import com.example.test1111.model.Constants;
import com.example.test1111.model.DAPreferences;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NAME = "com.example.task4_1.Message";
    public static final String EXTRA_NUMBER = "com.example.task4_1.number";
    private Button mSubmit;
    private EditText customerNameEd, customerMobileEd;
    private MyDatabase database;
    private String customerName,customerMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        //database initialization
        database = new MyDatabase(this);


        initializeViews();
    }

    private void initializeViews() {
        mSubmit = (Button) findViewById(R.id.submit);
        customerNameEd = (EditText) findViewById(R.id.input_name);
        customerMobileEd = (EditText) findViewById(R.id.input_number);
        getSupportActionBar().setTitle("TableCheck - Login");
        mSubmit.setOnClickListener(this);

    }

    /**
     *  After Login sends to Restaurant Screen
     */
    public void sendMessage() {
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(EXTRA_NAME, customerName);
        intent.putExtra(EXTRA_NUMBER, customerMobile);
        startActivity(intent);
    }

    /**
     *  Click Listener
     *
     */
    @Override
    //
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.submit:
                submitDetails();
                break;
        }

    }

    /**
     * Input data in editext field
     * then save in SharePrefernce File
     * Also Save in database(SQLITE DATABASE) so we can check that this mobile login earlier
     * so we can how hi last order
     */
    private void submitDetails() {
        customerName = customerNameEd.getText().toString();
        customerMobile = customerMobileEd.getText().toString();


        insertDatainDB();
        //
        saveDataSharedPrefrences();
        //

        if (customerName.isEmpty())
            Toast.makeText(this, "Please Input Your Name", Toast.LENGTH_SHORT).show();
        else if (customerMobile.isEmpty())
            Toast.makeText(this, "Please Input Your Mobile Number", Toast.LENGTH_SHORT).show();
        else
            sendMessage();
    }

    /**
     * History is DATABASE Model Class where we Setting Up Data
     */
    private void insertDatainDB() {
        History history = new History();
        history.setUserName(customerName);
        history.setUserNumber(customerMobile);
        database.insertData(history);
    }

    /**
     * Save Name and Number in SharePrefernce File
     * so we do not need to send data over Intent
     *
     */
    private void saveDataSharedPrefrences() {
        DAPreferences.putString(this, Constants.CustomerName,customerName);
        DAPreferences.putString(this, Constants.CustomerMobile,customerMobile);
    }
}
