package edu.wlac.cs.p02;

// Your IDE will show errors on these lines at first.
import org.junit.jupiter.api.Test;
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
}