package com.example.android.donationapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by NAREN on 09-03-2018.
 */

public class Item {

    private String itemType;
    private String itemDescription;
    private String boxID;
    private String notes;
    private boolean reserved;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;


    public Item(String itemType, String itemDescription, String boxID, String notes, boolean reserved){
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.boxID = boxID;
        this.notes = notes;
        this.reserved = reserved;
    }

    public Item() {}

    public String getItemType(){
        return this.itemType;
    }

    public String getItemDescription(){
        return this.itemDescription;
    }

    public String getBoxID(){
        return this.boxID;
    }

    public String getNotes(){
        return this.notes;
    }

    public boolean getReserved() {return this.reserved;}

    public void setReserved() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("reserved");
        mMessagesDatabaseReference.push().setValue("true");
        }

}
