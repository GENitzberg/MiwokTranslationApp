package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if existing view is being reused, otherwise inflate the value
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        //Get the Word object located at this position in the list
        Word currentWord = getItem(position);
        //Find the right TextView
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //Set the text in the view
        miwokTextView.setText(currentWord.getMiwokTranslation());
        //Find the right TextView
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //Set the text in the view
        defaultTextView.setText(currentWord.getDefaultTranslation());
        //Find the right ImageView
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.miwok_image_view);
        //Set the image in the view
        miwokImageView.setImageResource(currentWord.getImageTranslation());
        //Return the whole list item layout
        return listItemView;
    }
}
