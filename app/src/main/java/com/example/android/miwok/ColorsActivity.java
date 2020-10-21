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
        colorsArray.add(new Word("Red", "Wetetti"));
        colorsArray.add(new Word("Green", "Chokokki"));
        colorsArray.add(new Word("Brown", "Takakki"));
        colorsArray.add(new Word("Gray","Topoppi"));
        colorsArray.add(new Word("Black", "Kululli"));
        colorsArray.add(new Word("White", "Kelelli"));
        colorsArray.add(new Word("Dusty yellow", "Topiise"));
        colorsArray.add(new Word("Mustard yellow", "Chiwiite"));

        WordAdapter adapter = new WordAdapter(this, colorsArray);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}