package edu.wlac.cs.p02; // Defines package

import java.util.Scanner; // Import Scanner
import java.util.Arrays;

public class StringPuzzlesApplication {
	
	public static void main(String[] args) { // Main entry point
		String s1;
		String s2;
		
		Scanner sc = new Scanner(System.in); // Create Scanner
		
		System.out.print("Please enter the first string: \n");
		
		s1 = sc.nextLine(); // Read first line
		
		System.out.print("Please enter the second string: \n");
		s2 = sc.nextLine(); // Read second line
		
		sc.close(); // Close scanner
		
		// Print results of check methods
		System.out.print("\nString one is a palindrome?: " + isPalindrome(s1)); 
		System.out.print("\nString two is a palindrome?: " + isPalindrome(s2));
		System.out.println("\nIs string two an anagram of string one?: " + isAnagram(s1, s2));
		System.out.println("\nis substring: " + isSubstring(s1, s2));
	}
	
	public static boolean isAnagram(String s1, String s2) {
		if(s1 == null || s2 == null) return false;
		
		StringBuilder t1 = new StringBuilder();
		// Normalize s1
		for(int i = 0; i < s1.length(); i++) {
			char ch1 = s1.charAt(i);
			if(Character.isLetterOrDigit(ch1)) {
				t1.append(Character.toLowerCase(ch1));
			}
		}
		
		StringBuilder t2 = new StringBuilder();
		// Normalize s2
		for(int i = 0; i < s2.length(); i++) {
			char ch2 = s2.charAt(i);
			if(Character.isLetterOrDigit(ch2)) {
				t2.append(Character.toLowerCase(ch2));
			}
			
		}
		
		if(t1.length() != t2.length()) {
			return false; // Different lengths mean not anagrams
		}
		
		char[] t1Array = t1.toString().toCharArray();
		char[] t2Array = t2.toString().toCharArray();
		
		// Sort both arrays
		java.util.Arrays.sort(t1Array);
		java.util.Arrays.sort(t2Array);
		
		return java.util.Arrays.equals(t1Array, t2Array);
	}
	
	// Check if string is palindrome
	public static boolean isPalindrome(String s1) { 
		
		if(s1 == null) return false; 
		
		StringBuilder t = new StringBuilder(); 
		
		// Filter string to keep only letters/digits
		for(int i = 0; i < s1.length(); i++) { 
			
			char ch = s1.charAt(i);
			if(Character.isLetterOrDigit(ch)) { 
				t.append(Character.toLowerCase(ch)); 
			}
		}

		int left = 0, right = t.length() - 1; 
		
		// Compare characters from ends to middle
		while(left < right) { 
			if(t.charAt(left) != t.charAt(right)) { 
				return false; 
			}
			left++; 
			right--; 
		}
		return true; 
	}
	
	public static boolean isSubstring(String s1, String s2) {
		if(s1 == null || s2 == null) return false;
		
		// Normalize by removing spaces and lowercasing
		String clean_s1 = s1.toLowerCase().replace(" ", "");
		
		String clean_s2 = s2.toLowerCase().replace(" ", "");
		
		return clean_s1.contains(clean_s2);
	}
}