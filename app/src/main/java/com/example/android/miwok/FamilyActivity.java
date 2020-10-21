package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        ArrayList<Word> familyArray = new ArrayList<Word>();
        familyArray.add(new Word("Father", "Epe"));
        familyArray.add(new Word("Mother", "Eta"));
        familyArray.add(new Word("Son", "Angsi"));
        familyArray.add(new Word("Daughter","Tune"));
        familyArray.add(new Word("Older brother", "Taachi"));
        familyArray.add(new Word("Younger brother", "Chalitti"));
        familyArray.add(new Word("Older sister", "Tete"));
        familyArray.add(new Word("Younger sister", "Kolliti"));
        familyArray.add(new Word("Grandmother", "Ama"));
        familyArray.add(new Word("Grandfather", "Paapa"));

        WordAdapter adapter = new WordAdapter(this, familyArray);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}