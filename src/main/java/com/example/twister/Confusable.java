package com.example.twister;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class Confusable {
    static Map<String, String[]> CONFUSABLES_MAP = Map.of("a", new String[] {"\u237A", "\u0430", "\uD835\uDFAA" });

    public static ArrayList<String> getConfusables(String word) {
        ArrayList<String> wordPermutations = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            String[] confusableLetters = CONFUSABLES_MAP.get(String.valueOf(currLetter));

            if (confusableLetters != null) {
                for (String confusableLetter : confusableLetters) {
                    wordPermutations.add(word.substring(0, i) + confusableLetter + word.substring(i + 1));
                }
            }
        }

        System.out.println(wordPermutations);
        System.out.println(CONFUSABLES_MAP);
        return wordPermutations;
    }
}
