package exerciseString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCount {
    private final Map<String, Integer> wordFrequencies;

    public WordCount() {
        this.wordFrequencies = new HashMap<>();
    }

    /**
     * Counts the frequency of each word in the given text.
     *
     * @param text The input text.
     */
    public void countWords(String text) {
        // Split the text into words using a regular expression that matches non-letter characters.
        String[] words = text.toLowerCase().split("[^\\p{L}]+");

        // Count the frequency of each word.
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }
    }

    /**
     * Gets the word frequencies as a set of map entries.
     *
     * @return The set of word frequencies.
     */
    public Set<Map.Entry<String, Integer>> getWordFrequencies() {
        return wordFrequencies.entrySet();
    }
}