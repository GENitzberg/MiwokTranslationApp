package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        ArrayList<Word> phrasesArray = new ArrayList<Word>();
        phrasesArray.add(new Word("Where are you going?", "Minto wuksus"));
        phrasesArray.add(new Word("What is your name?", "Tinne oyaase'ne"));
        phrasesArray.add(new Word("My name is...", "Oyaaset"));
        phrasesArray.add(new Word("How are you feeling?","Michekses?"));
        phrasesArray.add(new Word("I'm feeling good", "Kuchi achit"));
        phrasesArray.add(new Word("Are you coming?", "Eenes'aa"));
        phrasesArray.add(new Word("Yes, I'm coming", "Hee'eenem"));
        phrasesArray.add(new Word("I'm coming", "Eenem"));
        phrasesArray.add(new Word("Let's go", "Yoowutis"));
        phrasesArray.add(new Word("Come here", "Enni'nem"));

        WordAdapter adapter = new WordAdapter(this, phrasesArray);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}