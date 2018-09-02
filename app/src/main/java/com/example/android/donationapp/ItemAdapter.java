package com.example.android.donationapp;

import java.util.ArrayList;

/**
 * Created by NAREN on 09-03-2018.
 */


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.FirebaseDatabase;

import junit.framework.Test;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.list_item, parent, false);
        }

        TextView itemTypeTextView = (TextView) convertView.findViewById(R.id.type);
        TextView descTextView = (TextView) convertView.findViewById(R.id.desc);
        TextView boxIDTextView = (TextView) convertView.findViewById(R.id.boxNumber);
        TextView notesTextView = (TextView) convertView.findViewById(R.id.note_ID);
        Button reserveButtonView = (Button) convertView.findViewById(R.id.reserve);

        final Item currentItem = getItem(position);

        if(!(currentItem.getReserved())) {


            itemTypeTextView.setText("Item Type: " + currentItem.getItemType());
            descTextView.setText("Description: " + currentItem.getItemDescription());
            boxIDTextView.setText("Donation Box ID: " + currentItem.getBoxID());
            notesTextView.setText("Notes: " + currentItem.getNotes());
            reserveButtonView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CharSequence text = "Success! Please collect the item within 24 hours";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    remove(currentItem);
                    notifyDataSetChanged();
                }
            });
        }


        return convertView;
    }
}