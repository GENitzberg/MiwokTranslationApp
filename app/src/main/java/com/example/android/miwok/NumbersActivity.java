package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        ArrayList<Word> numbersArray = new ArrayList<Word>();
        numbersArray.add(new Word("One", "Lutti"));
        numbersArray.add(new Word("Two", "Otiiko"));
        numbersArray.add(new Word("Three", "Tolookosu"));
        numbersArray.add(new Word("Four","Oyyisa"));
        numbersArray.add(new Word("Five", "Massokka"));
        numbersArray.add(new Word("Six", "Temmokka"));
        numbersArray.add(new Word("Seven","Kenekaku"));
        numbersArray.add(new Word("Eight", "Kawinta"));
        numbersArray.add(new Word("Nine", "Wo'e"));
        numbersArray.add(new Word("Ten", "Na'aacha"));

        //Creating the LinearLayout view to display the ArrayList on screen
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//        for (int i = 0; i < numbersArray.size(); i++ ) {
//            TextView wordView = new TextView(this);
//            wordView.setText(numbersArray.get(i));
//            rootView.addView(wordView);
//        }

        WordAdapter adapter = new WordAdapter(this, numbersArray);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}