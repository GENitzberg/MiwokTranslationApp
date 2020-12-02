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
        numbersArray.add(new Word("One", "Lutti", R.drawable.number_one));
        numbersArray.add(new Word("Two", "Otiiko", R.drawable.number_two));
        numbersArray.add(new Word("Three", "Tolookosu", R.drawable.number_three));
        numbersArray.add(new Word("Four","Oyyisa", R.drawable.number_four));
        numbersArray.add(new Word("Five", "Massokka", R.drawable.number_five));
        numbersArray.add(new Word("Six", "Temmokka", R.drawable.number_six));
        numbersArray.add(new Word("Seven","Kenekaku", R.drawable.number_seven));
        numbersArray.add(new Word("Eight", "Kawinta", R.drawable.number_eight));
        numbersArray.add(new Word("Nine", "Wo'e", R.drawable.number_nine));
        numbersArray.add(new Word("Ten", "Na'aacha", R.drawable.number_ten));

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