package com.example.lab6;

import android.text.TextUtils;

public class TextCounter {
    public static int getCharsCount(String phrase){
        return phrase.length();
    }
    public static int getWordsCount(String phrase){
        if (phrase.equals("")){
            return 0;
        }
        return phrase.split("\\W+").length;
    }

}
