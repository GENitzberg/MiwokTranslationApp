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

public class NumbersActivity extends AppCompatActivity {
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

        final ArrayList<Word> numbersArray = new ArrayList<Word>();
        numbersArray.add(new Word("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        numbersArray.add(new Word("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
        numbersArray.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        numbersArray.add(new Word("Four","Oyyisa", R.drawable.number_four, R.raw.number_four));
        numbersArray.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        numbersArray.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        numbersArray.add(new Word("Seven","Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbersArray.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbersArray.add(new Word("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbersArray.add(new Word("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));

        //Creating the LinearLayout view to display the ArrayList on screen
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//        for (int i = 0; i < numbersArray.size(); i++ ) {
//            TextView wordView = new TextView(this);
//            wordView.setText(numbersArray.get(i));
//            rootView.addView(wordView);
//        }

        WordAdapter adapter = new WordAdapter(this, numbersArray, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        //setting up the audio files
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = numbersArray.get(i);
                //if currently playing a media file, release then start a new one
                releaseMediaPlayer();

                //Request audio focus
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result ==AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResource());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        }

    /**
     * Clean up the media player by releasing its resources.
     */
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
    //when the app is stopped or paused, the media player is released
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


}