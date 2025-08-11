package edu.wlac.cs.p02;

import java.util.Scanner; 
import java.util.Arrays;
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
		
		System.out.print("Please enter the first string: \n");
		firstInput = scanner.nextLine(); // Read first line
		
		System.out.print("Please enter the second string: \n");
		secondInput = scanner.nextLine(); // Read second line
		
		// Print results of check methods
		System.out.println("\nResults of tests:");
		
		System.out.println(firstInput + (isPalindrome(firstInput) ? " is" : " is not") + " a palindrome");
		System.out.println(secondInput + (isPalindrome(secondInput) ? " is" : " is not") + " a palindrome");
		System.out.println(secondInput + (isAnagram(firstInput, secondInput) ? " is" : " is not") + " an anagram of " + firstInput);
		System.out.println(secondInput + (isSubstring(firstInput, secondInput) ? " is" : " is not") + " a substring of " + firstInput);
	}
	
	// Helper method to normalize string using Java Streams
	private static StringBuilder normalize(final String rawInput) {
		final String normalizedString = rawInput.chars() // Create IntStream of characters
				.filter(Character::isLetterOrDigit) // Keep only letters and digits
				.mapToObj(c -> (char) Character.toLowerCase(c)) // Convert to lowercase char
				.map(String::valueOf) // Convert chars to Strings
				.collect(Collectors.joining()); // Join them all together

		return new StringBuilder(normalizedString);
	}

	public static boolean isAnagram(final String text1, final String text2) {
		if(text1 == null || text2 == null) return false;
		
		// Use helper method to normalize both strings
		final StringBuilder normalizedText1 = normalize(text1);
		final StringBuilder normalizedText2 = normalize(text2);
		
		if(normalizedText1.length() != normalizedText2.length()) {
			return false; // Different lengths mean not anagrams
		}
		
		final char[] charArray1 = normalizedText1.toString().toCharArray();
		final char[] charArray2 = normalizedText2.toString().toCharArray();
		
		// Sort both arrays
		java.util.Arrays.sort(charArray1);
		java.util.Arrays.sort(charArray2);
		
		return java.util.Arrays.equals(charArray1, charArray2);
	}
	
	// Check if string is palindrome
	public static boolean isPalindrome(final String text) { 
		
		if(text == null) return false; 
		
		// Use helper method to normalize string
		final StringBuilder normalizedText = normalize(text);

		// Compare the normalized string to its reversed version
		final String forward = normalizedText.toString();
		final String backward = normalizedText.reverse().toString();

		return forward.equals(backward);
	}
	
	public static boolean isSubstring(final String text1, final String text2) {
		if(text1 == null || text2 == null) return false;
		
		// Use helper method to normalize both strings for consistency
		final String cleanText1 = normalize(text1).toString();
		final String cleanText2 = normalize(text2).toString();
		
		return cleanText1.contains(cleanText2);
	}
}