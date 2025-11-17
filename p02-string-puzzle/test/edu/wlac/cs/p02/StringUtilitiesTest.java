package edu.wlac.cs.p02;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class will test all the logic in our StringUtilities class.
 */
class StringUtilitiesTest {

    // This is our first test, from Sprint Item #2.
    @Test
    void testNormalize_Standard() {
        // We expect "Hello, World!" to become "helloworld"
        assertEquals("helloworld", StringUtilities.normalize("Hello, World!"));
        assertEquals("123go", StringUtilities.normalize("123 GO!!!"));
    }

    @Test
    void testNormalize_EdgeCases() {
        // Test what happens with symbols only
        assertEquals("", StringUtilities.normalize("!!!$$$###"));
        
        // Test what happens with an empty string
        assertEquals("", StringUtilities.normalize(""));
    }
    
    @Test
    void testNormalize_Null() {
        // Test what happens with a null input
        assertEquals("", StringUtilities.normalize(null));
    }
    
    @Test
    void testIsPalindrome_SimpleTrue() {
    	// Test simple, lowercase palindromes with both odd and even lengths
    	assertTrue(StringUtilities.isPalindrome("level"));
    	assertTrue(StringUtilities.isPalindrome("noon"));
    }
    
    @Test
    void testIsPalindrome_SimpleFalse() {
    	// Test simple false, lower-case palindromes with both odd and even lengths
    	assertFalse(StringUtilities.isPalindrome("abda"));
    	assertFalse(StringUtilities.isPalindrome("hello"));
    }
    
    @Test 
    void testIsPalindrome_ComplexTrue() {
    	// Tests complex non-clean inputs that are true palindromes mixed case punctuation spaces
    	assertTrue(StringUtilities.isPalindrome("Racecar"));
    	assertTrue(StringUtilities.isPalindrome("Madam, I'm Adam."));
    	assertTrue(StringUtilities.isPalindrome("A man, a plan, a canal: Panama"));
    }
    
    @Test 
    void testIsPalindrome_ComplexFalse() {
    	// Test complex inputs that contain non-alphanumeric characters 
        // but are NOT palindromes after normalization
    	assertFalse(StringUtilities.isPalindrome("Hello, World!"));
    	assertFalse(StringUtilities.isPalindrome("Test 123. 321 Go"));
    	assertFalse(StringUtilities.isPalindrome("Madam, I'm NOT Adam."));
    	}
    
    @Test 
    void testIsPalindrome_EdgeCases() {
    	assertFalse(StringUtilities.isPalindrome(null));
    	assertTrue(StringUtilities.isPalindrome(""));
    	assertTrue(StringUtilities.isPalindrome("a"));
    	assertTrue(StringUtilities.isPalindrome("!!!$$$"));
    }
    
    @Test
    void testIsAnagram_True() {
    	assertTrue(StringUtilities.isAnagram("", ""));
    	assertTrue(StringUtilities.isAnagram("listen", "silent"));
    	assertTrue(StringUtilities.isAnagram("secure", "rescue"));
    }
    
    @Test 
    void testIsAnagram_False() {
    	assertFalse(StringUtilities.isAnagram("hello", "world"));
    	assertFalse(StringUtilities.isAnagram("a", "aa"));
    }
    
    @Test 
    void testIsAnagram_ComplexTrue() {
    	assertTrue(StringUtilities.isAnagram("The eyes", "They see"));
    	assertTrue(StringUtilities.isAnagram("dirty room", "Dormitory"));
    }
    
    @Test
    void testIsAnagram_EdgeCases() {
    	assertFalse(StringUtilities.isAnagram(null, "text"));
    	assertFalse(StringUtilities.isAnagram("text", null));
    	assertTrue(StringUtilities.isAnagram("a", "a"));
    	assertFalse(StringUtilities.isAnagram("a", "aa"));
    	assertFalse(StringUtilities.isAnagram("a", ""));
    }
    
    @Test 
    void testIsSubstring_True() {
    	assertTrue(StringUtilities.isSubstring("caterpillar", "cat"));
    	assertTrue(StringUtilities.isSubstring("pinapple", "apple"));
    	assertTrue(StringUtilities.isSubstring("Hello world", "hello world"));
    	assertTrue(StringUtilities.isSubstring("Hello World!!!", "world"));
    	assertTrue(StringUtilities.isSubstring("Big Dog RUNNING", "dog run"));
    	assertTrue(StringUtilities.isSubstring("one-two-three", "twot"));
    	assertTrue(StringUtilities.isSubstring("one-two-three", "onetwo"));
    }
    
    @Test
    void testIsSubstring_false() {
    	assertFalse(StringUtilities.isSubstring("caterpillar", "dog"));
    	assertFalse(StringUtilities.isSubstring("hello", "hallo"));
    	assertFalse(StringUtilities.isSubstring("applepie", "pieapple"));
    	assertFalse(StringUtilities.isSubstring("small", "smaller"));
    }
    
    @Test
    void testIsSubstring_EdgeCases() {
        assertFalse(StringUtilities.isSubstring(null, "text"));
        assertFalse(StringUtilities.isSubstring("text", null));
        
        assertTrue(StringUtilities.isSubstring("text", "")); 
        assertTrue(StringUtilities.isSubstring("", ""));     
        
        assertTrue(StringUtilities.isSubstring("abc", "!!!")); 
        
        assertFalse(StringUtilities.isSubstring("", "a")); 
        
        assertFalse(StringUtilities.isSubstring("short", "longer text"));
    }
}