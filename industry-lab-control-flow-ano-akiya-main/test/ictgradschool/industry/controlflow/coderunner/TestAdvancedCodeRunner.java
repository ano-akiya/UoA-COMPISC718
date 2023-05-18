package ictgradschool.industry.controlflow.coderunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdvancedCodeRunner {
    private AdvancedCodeRunner cr;

    @BeforeEach
    public void setUp() {
        cr = new AdvancedCodeRunner();
    }

    @Test
    public void testReverseInt() {
        assertEquals(cr.reverseInt(1234), 4321);
        assertEquals(cr.reverseInt(111), 111);
        assertEquals(cr.reverseInt(9), 9);
        assertEquals(cr.reverseInt(10102361), 16320101);
        assertEquals(cr.reverseInt(-987123), -321789);
    }

    @Test
    public void testIsIntegerPalindromeTrue() {
        assertTrue(cr.isIntPalindrome(101));
        assertTrue(cr.isIntPalindrome(-101));
        assertTrue(cr.isIntPalindrome(3));
        assertTrue(cr.isIntPalindrome(88));
        assertTrue(cr.isIntPalindrome(0));
    }

    @Test
    public void testIsIntegerPalindromeFalse() {
        assertFalse(cr.isIntPalindrome(2369));
        assertFalse(cr.isIntPalindrome(2012));
        assertFalse(cr.isIntPalindrome(1234));
    }

    @Test
    public void testConvertIntToColTitleSimple() {
        assertEquals("A", cr.convertIntToColTitle(1));
        assertEquals("K", cr.convertIntToColTitle(11));
        assertEquals("Z", cr.convertIntToColTitle(26));
    }

    @Test
    public void testConvertIntToColTitleIntermediate() {
        assertEquals("AA", cr.convertIntToColTitle(27));
        assertEquals("CI", cr.convertIntToColTitle(87));
        assertEquals("ZZ", cr.convertIntToColTitle(702));
    }

    @Test
    public void testConvertIntToColTitleAdvanced() {
        assertEquals("AAA", cr.convertIntToColTitle(703));
        assertEquals("CUZ", cr.convertIntToColTitle(2600));
        assertEquals("XFD", cr.convertIntToColTitle(16384));
    }

    @Test
    public void testConvertIntToColTitleInvalid() {
        assertEquals("Input is invalid", cr.convertIntToColTitle(0));
        assertEquals("Input is invalid", cr.convertIntToColTitle(-1));
    }
}