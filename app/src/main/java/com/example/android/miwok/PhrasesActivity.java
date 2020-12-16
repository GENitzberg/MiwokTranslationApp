package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        final ArrayList<Word> phrasesArray = new ArrayList<Word>();
        phrasesArray.add(new Word("Where are you going?", "Minto wuksus", R.raw.phrase_where_are_you_going));
        phrasesArray.add(new Word("What is your name?", "Tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        phrasesArray.add(new Word("My name is...", "Oyaaset", R.raw.phrase_my_name_is));
        phrasesArray.add(new Word("How are you feeling?","Michekses?", R.raw.phrase_how_are_you_feeling));
        phrasesArray.add(new Word("I'm feeling good", "Kuchi achit", R.raw.phrase_im_feeling_good));
        phrasesArray.add(new Word("Are you coming?", "Eenes'aa", R.raw.phrase_are_you_coming));
        phrasesArray.add(new Word("Yes, I'm coming", "Hee'eenem", R.raw.phrase_yes_im_coming));
        phrasesArray.add(new Word("I'm coming", "Eenem", R.raw.phrase_im_coming));
        phrasesArray.add(new Word("Let's go", "Yoowutis", R.raw.phrase_lets_go));
        phrasesArray.add(new Word("Come here", "Enni'nem", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, phrasesArray, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        //setting up the audio files
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = phrasesArray.get(i);
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResource());
                mediaPlayer.start();
            }
        });

    }
}