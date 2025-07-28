// Donaven Bruce
// Program demonstrates recursion
// stringReplacerRecursive handles the first character
// Calls itself on the remaining substring until the base case empty string
// Combines partial results on return

import java.io.*;
import java.util.Scanner;

public class RecursionHW {

   public static void main(String[] args) throws IOException {
      // Two parallel arrays to rotate lowercase vowels a to e to i to o to u to a
      char[] vowelCycleFrom = { 'a', 'e', 'i', 'o', 'u' };
      char[] vowelCycleTo = { 'e', 'i', 'o', 'u', 'a' };

      // Read one full line from standard input
      Scanner userInput = new Scanner(System.in);
      System.out.println("Enter a word or sentence:");
      String originalText = userInput.nextLine();

      // Run the recursive replacer
      // index 0 holds the rebuilt text
      // index 1 holds the total swap count as a string
      String[] transformReport = stringReplacerRecursive(originalText, vowelCycleFrom, vowelCycleTo);

      // Print results
      System.out.println(originalText + " would be " + transformReport[0]);
      System.out.println("Number of characters replaced " + transformReport[1]);
   }

   public static String[] stringReplacerRecursive(String feed, char[] vowelFrom, char[] vowelTo) {
      // Base case stop on empty string
      if (feed.isEmpty()) {
         return new String[] { "", "0" };
      }

      // Inspect head character
      char headChar = feed.charAt(0);
      int didSwap = 0;

      // Rotate vowel if matched exactly once
      for (int slot = 0; slot < vowelFrom.length; slot++) {
         if (headChar == vowelFrom[slot]) {
            headChar = vowelTo[slot];
            didSwap = 1;
            break;
         }
      }

      // Recurse on the tail substring
      String[] tailOutcome = stringReplacerRecursive(feed.substring(1), vowelFrom, vowelTo);

      // Rebuild result by joining head with processed tail
      String rebuiltText = headChar + tailOutcome[0];

      // Accumulate total swaps
      int totalSwaps = didSwap + Integer.parseInt(tailOutcome[1]);

      // Return rebuilt text and total swaps as string
      return new String[] { rebuiltText, String.valueOf(totalSwaps) };
   }
}
