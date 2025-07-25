package edu.wlac.cs.p02;

import java.util.Scanner; 
import java.util.Arrays;

public class StringPuzzlesApplication {
	
	public static void main(String[] args) { 
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
	
	// Helper method to normalize string 
	private static StringBuilder normalize(String s) { //keep only letters/digits, lowercase
		StringBuilder t = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				t.append(Character.toLowerCase(ch));
			}
		}
		return t;
	}

	public static boolean isAnagram(String s1, String s2) {
		if(s1 == null || s2 == null) return false;
		
		// Use helper method to normalize both strings
		StringBuilder t1 = normalize(s1);
		StringBuilder t2 = normalize(s2);
		
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
		
		// Use helper method to normalize string
		StringBuilder t = normalize(s1);

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