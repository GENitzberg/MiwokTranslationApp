package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> numbersArray = new ArrayList<String>();
        numbersArray.add(0,"One");
        numbersArray.add(1,"Two");
        numbersArray.add(2,"Three");
        numbersArray.add(3,"Four");
        numbersArray.add(4,"Five");
        numbersArray.add(5,"Six");
        numbersArray.add(6,"Seven");
        numbersArray.add(7,"Eight");
        numbersArray.add(8,"Nine");
        numbersArray.add(9,"Ten");

        //Creating the LinearLayout view to display the ArrayList on screen
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//        for (int i = 0; i < numbersArray.size(); i++ ) {
//            TextView wordView = new TextView(this);
//            wordView.setText(numbersArray.get(i));
//            rootView.addView(wordView);
//        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbersArray);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}