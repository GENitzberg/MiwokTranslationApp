package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    int mBackgroundColor;
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColor) {
        super(context, 0, words);
        mBackgroundColor = backgroundColor;
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
        //Check whether the word has an image
        if(currentWord.hasImage()) {
            //Set the image in the view
            miwokImageView.setImageResource(currentWord.getImageTranslation());
            miwokImageView.setVisibility(View.VISIBLE);
        }
        else
            miwokImageView.setVisibility(View.GONE);
        //Set the background color according to category
        View textContainer = listItemView.findViewById(R.id.textLayout);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        textContainer.setBackgroundColor(color);
        //Return the whole list item layout
        return listItemView;
    }
}
