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
        familyArray.add(new Word("Father", "Epe", R.drawable.family_father));
        familyArray.add(new Word("Mother", "Eta", R.drawable.family_mother));
        familyArray.add(new Word("Son", "Angsi",R.drawable.family_son));
        familyArray.add(new Word("Daughter","Tune", R.drawable.family_daughter));
        familyArray.add(new Word("Older brother", "Taachi", R.drawable.family_older_brother));
        familyArray.add(new Word("Younger brother", "Chalitti", R.drawable.family_younger_brother));
        familyArray.add(new Word("Older sister", "Tete", R.drawable.family_older_sister));
        familyArray.add(new Word("Younger sister", "Kolliti", R.drawable.family_younger_sister));
        familyArray.add(new Word("Grandmother", "Ama", R.drawable.family_grandmother));
        familyArray.add(new Word("Grandfather", "Paapa", R.drawable.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, familyArray);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}