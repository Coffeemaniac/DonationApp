package com.example.android.donationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Charity_Registeration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity__registeration);
    }

    public void completionView(View view){
        Intent i = new Intent(this, CompletionActivity.class);
        startActivity(i);
    }
}
