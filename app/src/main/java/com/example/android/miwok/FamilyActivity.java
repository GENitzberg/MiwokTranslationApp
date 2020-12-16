package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        final ArrayList<Word> familyArray = new ArrayList<Word>();
        familyArray.add(new Word("Father", "Epe", R.drawable.family_father,R.raw.family_father));
        familyArray.add(new Word("Mother", "Eta", R.drawable.family_mother, R.raw.family_mother));
        familyArray.add(new Word("Son", "Angsi",R.drawable.family_son, R.raw.family_son));
        familyArray.add(new Word("Daughter","Tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyArray.add(new Word("Older brother", "Taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyArray.add(new Word("Younger brother", "Chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyArray.add(new Word("Older sister", "Tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyArray.add(new Word("Younger sister", "Kolliti", R.drawable.family_younger_sister, R.raw.family_younger_brother));
        familyArray.add(new Word("Grandmother", "Ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyArray.add(new Word("Grandfather", "Paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, familyArray, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        //setting up the audio files
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = familyArray.get(i);
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResource());
                mediaPlayer.start();
            }
        });
    }
}