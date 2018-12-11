package com.example.test1111;

import android.app.Application;

import com.example.test1111.model.AfricaFood;
import com.example.test1111.model.NorthAmericaFood;

import java.util.ArrayList;

/**
 *  Applicayion class
 * which active through until Application Destroys
 */

public class DiningApp extends Application {

    public  static ArrayList<NorthAmericaFood> americaFoodArrayList;
    public  static ArrayList<AfricaFood> africaFoodArrayList;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
