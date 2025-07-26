package edu.wlac.cs.p02;

import java.util.Scanner; 
import java.util.Arrays;

public class StringPuzzlesApplication {
	
	public static void main(String[] args) { 
		String firstInput;
		String secondInput;
		
		Scanner inputScanner = new Scanner(System.in); // Create Scanner
		
		System.out.print("Please enter the first string: \n");
		
		firstInput = inputScanner.nextLine(); // Read first line
		
		System.out.print("Please enter the second string: \n");
		secondInput = inputScanner.nextLine(); // Read second line
		
		inputScanner.close(); // Close scanner
		
		// Print results of check methods
		System.out.print("\nString one is a palindrome?: " + isPalindrome(firstInput)); 
		System.out.print("\nString two is a palindrome?: " + isPalindrome(secondInput));
		System.out.println("\nIs string two an anagram of string one?: " + isAnagram(firstInput, secondInput));
		System.out.println("\nis substring: " + isSubstring(firstInput, secondInput));
	}
	
	// Helper method to normalize string 
	private static StringBuilder normalize(String rawInput) { //keep only letters/digits, lowercase
		StringBuilder normalizedBuilder = new StringBuilder();
		for(int i = 0; i < rawInput.length(); i++) {
			char currentChar = rawInput.charAt(i);
			if(Character.isLetterOrDigit(currentChar)) {
				normalizedBuilder.append(Character.toLowerCase(currentChar));
			}
		}
		return normalizedBuilder;
	}

	public static boolean isAnagram(String text1, String text2) {
		if(text1 == null || text2 == null) return false;
		
		// Use helper method to normalize both strings
		StringBuilder normalizedText1 = normalize(text1);
		StringBuilder normalizedText2 = normalize(text2);
		
		if(normalizedText1.length() != normalizedText2.length()) {
			return false; // Different lengths mean not anagrams
		}
		
		char[] charArray1 = normalizedText1.toString().toCharArray();
		char[] charArray2 = normalizedText2.toString().toCharArray();
		
		// Sort both arrays
		java.util.Arrays.sort(charArray1);
		java.util.Arrays.sort(charArray2);
		
		return java.util.Arrays.equals(charArray1, charArray2);
	}
	
	// Check if string is palindrome
	public static boolean isPalindrome(String text) { 
		
		if(text == null) return false; 
		
		// Use helper method to normalize string
		StringBuilder normalizedText = normalize(text);

		int leftIndex = 0, rightIndex = normalizedText.length() - 1; 
		
		// Compare characters from ends to middle
		while(leftIndex < rightIndex) { 
			if(normalizedText.charAt(leftIndex) != normalizedText.charAt(rightIndex)) { 
				return false; 
			}
			leftIndex++; 
			rightIndex--; 
		}
		return true; 
	}
	
	public static boolean isSubstring(String text1, String text2) {
		if(text1 == null || text2 == null) return false;
		
		// Normalize by removing spaces and lowercasing
		String cleanText1 = text1.toLowerCase().replace(" ", "");
		
		String cleanText2 = text2.toLowerCase().replace(" ", "");
		
		return cleanText1.contains(cleanText2);
	}
}