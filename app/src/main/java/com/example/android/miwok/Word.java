package com.example.android.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;

    //create the constructor
    public Word(String defaultTranslation, String miwokTranslation)
    {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }
    //get the Miwok translation of the selected word
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    //get the default translation of the selected word
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
}
