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
        // Initialize choice to 'y' so the loop runs at least once
        String choice = "y";

        // Continue looping as long as the user enters 'y' or 'Y'
        while (choice.equalsIgnoreCase("y")) {
            final String firstInput;
            final String secondInput;

            System.out.printf("Please enter the first string: %n");
            firstInput = scanner.nextLine();

            System.out.printf("Please enter the second string: %n");
            secondInput = scanner.nextLine();

            System.out.println(System.lineSeparator() + "Results of tests:");

            System.out.println(firstInput + (StringUtilities.isPalindrome(firstInput) ? " is" : " is not") + " a palindrome");
            System.out.println(secondInput + (StringUtilities.isPalindrome(secondInput) ? " is" : " is not") + " a palindrome");
            System.out.println(secondInput + (StringUtilities.isAnagram(firstInput, secondInput) ? " is" : " is not") + " an anagram of " + firstInput);
            System.out.println(secondInput + (StringUtilities.isSubstring(firstInput, secondInput) ? " is" : " is not") + " a substring of " + firstInput);

            // Ask the user if they want to continue
            System.out.printf("%nWould you like to test two new strings? (y/n): ");
            choice = scanner.nextLine();
            // Add a blank line for better readability between runs
            System.out.println();
        }

        System.out.println("Thank you for using String Puzzles! Goodbye.");
    }
}