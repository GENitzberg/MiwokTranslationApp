package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                //Pause Playback
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                //Resume Playback
                mediaPlayer.start();
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                //Stop playback
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

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
                //if currently playing a media file, release then start a new one
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResource());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });


    }
    private void releaseMediaPlayer(){
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            //abandon audio focus
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}