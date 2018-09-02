package com.example.android.donationapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.crypto.KeyGenerator;

public class donate_item_description extends AppCompatActivity {

    private EditText mItemType, mItemdescription, mBoxID, mNotes;
    private Button mDone;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;


    private void alert(Context context){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Secure Passcode");
        alertDialog.setMessage("Please enter the following passcode to open the box  : 1234");
        alertDialog.show();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_item_description);


        // Declare UI buttons
        mItemType = (EditText) findViewById(R.id.item_type);
        mItemdescription = (EditText) findViewById(R.id.description_note);
        mBoxID = (EditText) findViewById(R.id.box_id);
        mNotes = (EditText) findViewById(R.id.noteID);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("Items");



    }

    public void addToDataBaseItems(View view) {
        Item item = new Item(mItemType.getText().toString(), mItemdescription.getText().toString(), mBoxID.getText().toString(), mNotes.getText().toString(), false);
        mDatabaseReference.push().setValue(item);
        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;
        text = "Great Job! Your item has been added ";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        alert(context);
    }

    public void openMaps(View view){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("google.navigation:q=kudlu+gate+bangalore"));
        startActivity(intent);

                               }
    }


