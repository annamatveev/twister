package com.example.twister;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class Confusable {
    static Map<Character, Character[]> CONFUSABLES_MAP = Map.of('a', new Character[] {'\u0061', '\u0251', '\u03B1', '\u0430', '\u237A', '\uFF41' },
            'b', new Character[] {'\u0062', '\u0184', '\u042C', '\u13CF', '\u1472', '\u15AF' },
            'c', new Character[] {'\u0063', '\u03F2', '\u0441', '\u1D04', '\u217D', '\u2CA5', '\uABAF', '\uFF43' },
            'd', new Character[] {'\u0064', '\u0501', '\u13E7', '\u146F', '\u2146', '\u217E'  },
            'e', new Character[] {'\u0065', '\u0435', '\u04BD', '\u212E', '\u212F', '\u2147', '\uFF45' },
            'f', new Character[] {'\u0066', '\u017F', '\u0584', '\u1E9D', '\uA799', '\uAB35' },
            'g', new Character[] {'\u0067', '\u018D', '\u0261', '\u0581', '\u1D83', '\u210A', '\uFF47' },
            'h', new Character[] {'\u0068', '\u04BB', '\u0570', '\u13C2', '\u210E', '\uFF48' },
            'i', new Character[] {'\u0069', '\u0131', '\u0269', '\u026A', '\u02DB', '\u037A', '\u03B9', '\u0456','\u13A5', '\u1FBE', '\u2139', '\u2148', '\u2170', '\u2373', '\uFF49' },
            'j', new Character[] {'\u006A', '\u03F3', '\u0458', '\u2149', '\uFF4A' });

    public static ArrayList<String> getConfusables(String word) {
        ArrayList<String> wordPermutations = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            Character[] confusableLetters = CONFUSABLES_MAP.get(currLetter);

            if (confusableLetters != null) {
                for (Character confusableLetter : confusableLetters) {
                    wordPermutations.add(word.substring(0, i) + confusableLetter + word.substring(i + 1));
                }
            }
        }

        System.out.println(wordPermutations);
        System.out.println(CONFUSABLES_MAP);
        return wordPermutations;
    }
}
