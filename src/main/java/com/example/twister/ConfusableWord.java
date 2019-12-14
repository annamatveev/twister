package com.example.twister;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class ConfusableWord {

    public static ArrayList<String> getConfusableWords(String word) {
        ArrayList<String> wordPermutations = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            ConfusableLetter currLetter = new ConfusableLetter(Character.toString(word.charAt(i)));

            for (String alternativeLetter : currLetter.getConfusables()) {
                wordPermutations.add(word.substring(0, i) + alternativeLetter + word.substring(i + 1));
            }
        }

        return wordPermutations;
    }
}
