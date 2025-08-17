package edu.wlac.cs.p02;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A utility class containing static methods for string puzzle logic.
 * This class cannot be instantiated.
 */
public class StringUtilities {

    // A private constructor prevents this utility class from being instantiated.
    private StringUtilities() {
    }

    // Helper method to normalize string using Java Streams
    private static String normalize(final String rawInput) {
        return rawInput.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(c -> (char) Character.toLowerCase(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * Checks if two strings are anagrams of each other using an efficient
     * character-counting algorithm O(N) that supports full Unicode.
     * @param text1 The first string to check.
     * @param text2 The second string to check.
     * @return true if they are anagrams, false otherwise.
     */
    public static boolean isAnagram(final String text1, final String text2) {
        if (text1 == null || text2 == null) return false;

        final String normalizedText1 = normalize(text1);
        final String normalizedText2 = normalize(text2);

        if (normalizedText1.length() != normalizedText2.length()) {
            return false;
        }

        // Use a HashMap to count character frequencies.
        // This supports all Unicode characters, unlike a fixed-size array.
        final Map<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < normalizedText1.length(); i++) {
            char c1 = normalizedText1.charAt(i);
            charCounts.put(c1, charCounts.getOrDefault(c1, 0) + 1);

            char c2 = normalizedText2.charAt(i);
            charCounts.put(c2, charCounts.getOrDefault(c2, 0) - 1);
        }

        // If they are anagrams, all final counts in the map must be zero.
        for (int count : charCounts.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if a string is a palindrome.
     * @param text The string to check.
     * @return true if it is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(final String text) {
        if (text == null) return false;
        final String normalizedText = normalize(text);
        final String backward = new StringBuilder(normalizedText).reverse().toString();
        return normalizedText.equals(backward);
    }

    /**
     * Checks if the second string is a substring of the first.
     * @param text1 The main string.
     * @param text2 The potential substring.
     * @return true if text2 is a substring of text1, false otherwise.
     */
    public static boolean isSubstring(final String text1, final String text2) {
        if (text1 == null || text2 == null) return false;
        final String cleanText1 = normalize(text1);
        final String cleanText2 = normalize(text2);
        return cleanText1.contains(cleanText2);
    }
}