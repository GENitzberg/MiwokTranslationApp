package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        ArrayList<Word> colorsArray = new ArrayList<Word>();
        colorsArray.add(new Word("Red", "Wetetti", R.drawable.color_red));
        colorsArray.add(new Word("Green", "Chokokki", R.drawable.color_green));
        colorsArray.add(new Word("Brown", "Takakki", R.drawable.color_brown));
        colorsArray.add(new Word("Gray","Topoppi", R.drawable.color_gray));
        colorsArray.add(new Word("Black", "Kululli", R.drawable.color_black));
        colorsArray.add(new Word("White", "Kelelli", R.drawable.color_white));
        colorsArray.add(new Word("Dusty yellow", "Topiise", R.drawable.color_dusty_yellow));
        colorsArray.add(new Word("Mustard yellow", "Chiwiite", R.drawable.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, colorsArray, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}