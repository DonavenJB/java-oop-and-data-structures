package edu.wlac.cs.p02;

import java.util.Scanner; 
import java.util.stream.Collectors; 

public class StringPuzzlesApplication {
	
	public static void main(String[] args) { 
		// Use try-with-resources to automatically close the scanner
		try (final Scanner inputScanner = new Scanner(System.in)) { 
			runUserInterface(inputScanner);
		} // Scanner is automatically closed here, even if an exception occurs
	}
	
	// Method to handle all user interaction
	private static void runUserInterface(final Scanner scanner) {
		final String firstInput;
		final String secondInput;
		
		// Use printf with %n for cross-platform newlines
		System.out.printf("Please enter the first string: %n");
		firstInput = scanner.nextLine(); // Read first line
		
		System.out.printf("Please enter the second string: %n");
		secondInput = scanner.nextLine(); // Read second line
		
		// Print results of check methods using cross-platform newline
		System.out.println(System.lineSeparator() + "Results of tests:");
		
		System.out.println(firstInput + (isPalindrome(firstInput) ? " is" : " is not") + " a palindrome");
		System.out.println(secondInput + (isPalindrome(secondInput) ? " is" : " is not") + " a palindrome");
		System.out.println(secondInput + (isAnagram(firstInput, secondInput) ? " is" : " is not") + " an anagram of " + firstInput);
		System.out.println(secondInput + (isSubstring(firstInput, secondInput) ? " is" : " is not") + " a substring of " + firstInput);
	}
	
	// Helper method to normalize string using Java Streams
	// Returns String instead of StringBuilder
	private static String normalize(final String rawInput) {
		return rawInput.chars() // Create IntStream of characters
				.filter(Character::isLetterOrDigit) // Keep only letters and digits
				.mapToObj(c -> (char) Character.toLowerCase(c)) // Convert to lowercase char
				.map(String::valueOf) // Convert chars to Strings
				.collect(Collectors.joining()); // Join them all together into a String
	}

	/**
	 * Checks if two strings are anagrams of each other.
	 * @param text1 The first string to check.
	 * @param text2 The second string to check.
	 * @return true if they are anagrams, false otherwise. Returns false if either input is null.
	 */
	public static boolean isAnagram(final String text1, final String text2) {
		if(text1 == null || text2 == null) return false;
		
		// Use helper method to normalize both strings
		final String normalizedText1 = normalize(text1);
		final String normalizedText2 = normalize(text2);
		
		if(normalizedText1.length() != normalizedText2.length()) {
			return false; // Different lengths mean not anagrams
		}
		
		final char[] charArray1 = normalizedText1.toCharArray();
		final char[] charArray2 = normalizedText2.toCharArray();
		
		// Sort both arrays
		java.util.Arrays.sort(charArray1);
		java.util.Arrays.sort(charArray2);
		
		return java.util.Arrays.equals(charArray1, charArray2);
	}
	
	/**
	 * Checks if a string is a palindrome.
	 * @param text The string to check.
	 * @return true if it is a palindrome, false otherwise. Returns false if input is null.
	 */
	public static boolean isPalindrome(final String text) { 
		
		if(text == null) return false; 
		
		// Use helper method to normalize string
		final String normalizedText = normalize(text);

		// Create a StringBuilder just for the reversal operation
		final String backward = new StringBuilder(normalizedText).reverse().toString();

		return normalizedText.equals(backward);
	}
	
	/**
	 * Checks if the second string is a substring of the first.
	 * @param text1 The main string.
	 * @param text2 The potential substring.
	 * @return true if text2 is a substring of text1, false otherwise. Returns false if either input is null.
	 */
	public static boolean isSubstring(final String text1, final String text2) {
		if(text1 == null || text2 == null) return false;
		
		// Use helper method to normalize both strings for consistency
		final String cleanText1 = normalize(text1);
		final String cleanText2 = normalize(text2);
		
		return cleanText1.contains(cleanText2);
	}
}