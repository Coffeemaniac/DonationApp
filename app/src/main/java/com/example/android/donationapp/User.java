package com.example.android.donationapp;

/**
 * Created by NAREN on 09-03-2018.
 */

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public User(String name, String email, String phoneNumber, String address){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getAddress(){
        return this.address;
    }


}
