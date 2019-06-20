package io.exercism.piglatin;

import java.util.Arrays;
import java.util.List;

public class PigLatinTranslator {


    public String translate(String wordToTranslate) {

        String bodyOfWord = new String();
        String preFixWord = new String();
        String posFix = "ay";
        String phrase ="";

        List<String> sentence = Arrays.asList(wordToTranslate.split(" "));

        for (String word : sentence) {

            Integer preFixPosition;

            if (wordStartsWithConsonant(word)) {
                if (word.startsWith("ch") ||
                    word.startsWith("th") ||
                    word.startsWith("sch") ||
                    word.startsWith("rh")) {

                    if (word.startsWith("thr") || word.startsWith("sch")) {
                        bodyOfWord = word.substring(3);
                        preFixWord = word.substring(0, 3);
                    } else {
                        bodyOfWord = word.substring(2);
                        preFixWord = word.substring(0, 2);
                    }

                } else {
                    preFixPosition = word.indexOf("qu");
                    if (preFixPosition == 0) {
                        bodyOfWord = word.substring(2);
                        preFixWord = word.substring(0, 2);
                    } else if (preFixPosition == 1) {
                        bodyOfWord = word.substring(3);
                        preFixWord = word.substring(0, 3);
                    } else {
                        bodyOfWord = word.substring(1);
                        preFixWord = word.substring(0, 1);
                    }
                }
                bodyOfWord = bodyOfWord + preFixWord + posFix;
            } else {
                bodyOfWord = word + posFix;
            }

            if (phrase.isEmpty()){
                phrase=bodyOfWord;

            }else {
                phrase = phrase + " " + bodyOfWord;
            }

        }

        return phrase;
    }

    private boolean wordStartsWithConsonant(String wordToTranslate) {

        if (wordToTranslate.startsWith("xr") || wordToTranslate.startsWith("yt") || wordToTranslate.startsWith("a") || wordToTranslate.startsWith("e") || wordToTranslate.startsWith("i") || wordToTranslate.startsWith("o") || wordToTranslate.startsWith("u")) {
            return false;
        }
        return true;
    }

}
