package edu.wlac.cs.p02;

import java.util.Scanner;

public class StringPuzzlesApplication {
	
	public static void main(String[] args) {
		String s1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter the first string:");
		
		s1 = sc.nextLine();
		
		sc.close();
		
		System.out.print("String one is a palidrome?" + isPalidrome(s1));
		
	}
	
	public static boolean isPalidrome(String s1) {
		
		if(s1 == null) return false;
		
		StringBuilder t = new StringBuilder();
		
		for(int i = 0; i < s1.length(); i++) {
			
			char ch = s1.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				t.append(Character.toLowerCase(ch));
			}
		}
		int left = 0, right = t.length() - 1;
		while(left < right) {
			if(t.charAt(left) != t.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}