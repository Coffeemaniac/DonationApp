package com.example.android.donationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.atomic.AtomicReference;

import static android.view.View.INVISIBLE;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    // UI elements
    private EditText mName, mEmailID, mPhone, mAddress;
    private Button btnDonate;
    private CheckBox chkCharity, chkDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TODO : Declare Buttons and EditText on create
        mName = (EditText) findViewById(R.id.NameID);
        mEmailID = (EditText) findViewById(R.id.emailID);
        mPhone = (EditText) findViewById(R.id.phone_number);
        mAddress = (EditText) findViewById(R.id.address);
        btnDonate = (Button) findViewById(R.id.donate_button);
        chkCharity = (CheckBox) findViewById(R.id.charity_box);
        chkDonate = (CheckBox) findViewById(R.id.donate_box);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("Users");

        btnDonate.setOnClickListener(doSomething);
    }



    private View.OnClickListener doSomething = new View.OnClickListener() {
        public void onClick(View v) {
            goToActivity(v);
        }
    };


     public void addToDataBase(){
        User user = new User(mName.getText().toString(), mEmailID.getText().toString(), mPhone.getText().toString(), mAddress.getText().toString());
        mDatabaseReference.push().setValue(user);
     }

    public void itemClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()) {
            btnDonate.setText("Donate");
            btnDonate.setVisibility(View.VISIBLE);
            chkCharity.setVisibility(View.INVISIBLE);
        }
        else{
            normal_donate();
        }
        }
    public void itemClicked_charity(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()) {
            btnDonate.setText("Register your Charity");
            btnDonate.setVisibility(View.VISIBLE);
            chkDonate.setVisibility(View.INVISIBLE);
        }
        else{
            normal();
        }
    }
    private void normal(){
         btnDonate.setVisibility(View.INVISIBLE);
         btnDonate.setText("Donate");
         chkDonate.setVisibility(View.VISIBLE);
    }

    private void normal_donate(){
        btnDonate.setVisibility(View.INVISIBLE);
        btnDonate.setText("Donate");
        chkCharity.setVisibility(View.VISIBLE);
    }

    public void goToActivity(View view) {
        addToDataBase();
        String class_selection = (String) btnDonate.getText();
        if (class_selection.compareTo("Donate") == 0) {
            Intent i = new Intent(this, donate_item_description.class);
            startActivity(i);
        } else {
            Intent j = new Intent(this, Charity_Registeration.class);
            startActivity(j);
        }

    }

}










