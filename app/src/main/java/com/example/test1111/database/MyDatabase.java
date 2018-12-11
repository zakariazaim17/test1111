package com.example.test1111.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class MyDatabase extends SQLiteOpenHelper
{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "restaurants.db";
    public static final String TABLE_NAME = "restaurant";
    private static final String KEY_ID = "id";
    public static final String ITEM_ID = "eventid";
    public static final String USER_NAME = "name";
    public static final String USER_NUMBER = "number";
    public static final String ITEM_QUNTITY = "quantity";
    public static final String RESTAURANT_NAME = "restaurantName";


    public MyDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db;
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String CREATE_ALARM_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + ITEM_ID + " TEXT," + USER_NAME + " TEXT,"+ RESTAURANT_NAME + " TEXT," + ITEM_QUNTITY + " TEXT,"
               + USER_NUMBER + " TEXT)" ;

        db.execSQL(CREATE_ALARM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );

    }
    public long insertData(History history)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_ID,history.getItem_id());
        contentValues.put(ITEM_QUNTITY,history.getQuntity());
        contentValues.put(USER_NAME,history.getUserName());
        contentValues.put(USER_NUMBER, history.getUserNumber());
        contentValues.put(RESTAURANT_NAME, history.getRestaurantName());

        long cnt = db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return cnt;
    }

    public ArrayList<History> getLoginData(){
        ArrayList<History> data = new ArrayList<>();
        String query = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do
            {
                History longtap = new History();
                longtap.setItem_id(cursor.getString(1));
                longtap.setUserName(cursor.getString(2));
                longtap.setRestaurantName(cursor.getString(3));
                longtap.setQuntity(cursor.getString(4));
                longtap.setUserNumber(cursor.getString(5));
                data.add(longtap);

            }
            while (cursor.moveToNext());


        }
        cursor.close();
        db.close();

        return data;
    }
    public boolean updateStatus(String mobileNumber, String resturantName,String itemId) {
        Log.e("Update_Status",resturantName+"  "+mobileNumber);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_ID, itemId);
        contentValues.put(RESTAURANT_NAME, resturantName);

        // updating row
        return db.update(TABLE_NAME, contentValues, USER_NUMBER + " = ?" , new String[] { mobileNumber })>0;
    }



    public boolean deleteRow(String eventId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ITEM_ID + " = ?" , new String[] { eventId }) > 0;
    }

    public int getRowsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }


}
