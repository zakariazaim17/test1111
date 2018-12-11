package com.example.test1111.database;


/**
 * class for Database
 */
public class History {

    int _id;
    private String item_id;
    private String quntity;
    private String userName;
    private String userNumber;
    private String restaurantName;

    public History() {

    }

    public History(String item_id, String quntity, String userName, String userNumber,String restaurantName) {
        this.item_id = item_id;
        this.quntity = quntity;
        this.userName = userName;
        this.userNumber = userNumber;
        this.restaurantName = restaurantName;
    }
    //

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getQuntity() {
        return quntity;
    }

    public void setQuntity(String quntity) {
        this.quntity = quntity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}