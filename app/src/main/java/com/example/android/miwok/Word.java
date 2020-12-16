package com.example.android.miwok;

import android.media.Image;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageTranslation = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResource;

    //create the constructor
    public Word(String defaultTranslation, String miwokTranslation, int audioResource)
    {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResource = audioResource;
    }
    public Word(String defaultTranslation, String miwokTranslation, int imageTranslation, int audioResource){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageTranslation = imageTranslation;
        mAudioResource = audioResource;
    }
    //get the Miwok translation of the selected word
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    //get the default translation of the selected word
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    //get the image translation of the selected word
    public int getImageTranslation(){
        return mImageTranslation;
    }
    //get the audio resource of the selected word
    public int getAudioResource(){
        return mAudioResource;
    }

    public boolean hasImage(){
        if(mImageTranslation == NO_IMAGE_PROVIDED){
            return false;
        }
        else
            return true;
    }
}
