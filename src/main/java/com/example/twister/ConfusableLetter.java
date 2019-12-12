package com.example.twister;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfusableLetter {

    static Map<String, String[]> UNICODE_CONFUSABLES = Map.of("a", new String[] {"\u0061", "\u0251", "\u03B1", "\u0430", "\u237A", "\uFF41" },
            "b", new String[] {"\u0062", "\u0184", "\u042C", "\u13CF", "\u1472", "\u15AF"});

    static Map<String, String[]> MULTI_LETTER_CONFUSABLES = Map.of("a", new String[] {"ci" },
            "d", new String[] { "cl" },
            "g", new String[] {" cj" },
            "m", new String[] { "rn" },
            "w", new String[] {"vv" });

    static Map<String, String[]> SIMILAR_CONFUSABLES = Map.of("a", new String[] {"ci" },
            "c", new String[] { "(" },
            "l", new String[] { "1", "I" },
            "g", new String[] {" 9", "q" },
            "m", new String[] { "rn" },
            "w", new String[] {"vv" });

    private String letter;

    public ConfusableLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public String[] getAlternations() {
        return UNICODE_CONFUSABLES.get(this.letter);
    }

    public String[] getMultiLetters() {
        return MULTI_LETTER_CONFUSABLES.get(this.letter);
    }

    public String[] getSimilarities() {
        return SIMILAR_CONFUSABLES.get(this.letter);
    }

    public String[] getConfusables() {
        return Stream.of(this.getAlternations(), this.getMultiLetters(), this.getSimilarities()).filter(Objects::nonNull).flatMap(Stream::of).toArray(String[]::new);
    }

}
