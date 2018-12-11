package com.example.test1111.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *This is SharedPreferences class used for Locally storing String or other variables too
 */
public class DAPreferences {

    /**
     *Calling SharedPrefernce Class and make it private file Give Name "AT_PREF" to that file
     */
    private static SharedPreferences getPreference(Context context){
       return context.getSharedPreferences("AT_PREF", Context.MODE_PRIVATE);
    }

    /**
     *If we want to save String then we have to call this method
     */
    public static void putString(Context context,String key,String value){
        getPreference(context).edit().putString(key,value).apply();
    }

    /**
     *If we want to read String then we have to call this method
     */
    public static String readString(Context context,String key){
        return getPreference(context).getString(key,"");
    }

}
