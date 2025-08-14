package edu.wlac.cs.p02;

import java.util.Scanner;

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

        System.out.println(firstInput + (StringUtilities.isPalindrome(firstInput) ? " is" : " is not") + " a palindrome");
        System.out.println(secondInput + (StringUtilities.isPalindrome(secondInput) ? " is" : " is not") + " a palindrome");
        System.out.println(secondInput + (StringUtilities.isAnagram(firstInput, secondInput) ? " is" : " is not") + " an anagram of " + firstInput);
        System.out.println(secondInput + (StringUtilities.isSubstring(firstInput, secondInput) ? " is" : " is not") + " a substring of " + firstInput);
    }
}