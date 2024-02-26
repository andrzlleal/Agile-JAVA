package testesString;

import exerciseString.WordCount;

public class WordCountTest {
    public static void main(String[] args) {
        WordCount wordCounter = new WordCount();
        String exerciseText = "Create a String literal using the first two sentences of this exercise. "
                + "You will create a WordCount class to parse through the text and count "
                + "the number of instances of each word.";

        wordCounter.countWords(exerciseText);

        System.out.println("Word frequencies:");
        wordCounter.getWordFrequencies().forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
