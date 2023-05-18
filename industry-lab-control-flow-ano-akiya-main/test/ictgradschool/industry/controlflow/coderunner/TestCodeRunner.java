package ictgradschool.industry.controlflow.coderunner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCodeRunner {
    private CodeRunner cr;

    @BeforeEach
    public void setUp() {
        cr = new CodeRunner();
    }

    @Test
    public void testAreSameNameSameName() {
        assertEquals("Same name", cr.areSameName("John", "John"));
        assertEquals("Same name", cr.areSameName("Vithya", "Vithya"));
        assertEquals("Same name", cr.areSameName("Jack", "Jack"));
    }

    @Test
    public void testAreSameNameNoMatch() {
        assertEquals("No match", cr.areSameName("Stephen", "Joseph"));
        assertEquals("No match", cr.areSameName("Henry", "Thomas"));
        assertEquals("No match", cr.areSameName("David", "Ernie"));
    }

    @Test
    public void testAreSameNameSameFirstLetter() {
        assertEquals("Same first letter", cr.areSameName("Ann", "Anna"));
        assertEquals("Same first letter", cr.areSameName("Betty", "Barbara"));
        assertEquals("Same first letter", cr.areSameName("Owen", "Olive"));
    }

    @Test
    public void testIsLeapYearTrue() {
        assertTrue(cr.isALeapYear(2000));
        assertTrue(cr.isALeapYear(2012));
        assertTrue(cr.isALeapYear(1996));
    }

    @Test
    public void testIsLeapYearFalse() {
        assertFalse(cr.isALeapYear(1900));
        assertFalse(cr.isALeapYear(1800));
        assertFalse(cr.isALeapYear(1601));
    }

    @Test
    public void testReverseString() {
        assertEquals("cba", cr.reverseString("abc"));
        assertEquals("!dlroW olleH", cr.reverseString("Hello World!"));
        assertEquals("16320101", cr.reverseString("10102361"));
        assertEquals("z", cr.reverseString("z"));
    }

    @Test
    public void testIsPrimeTrue() {
        assertTrue(cr.isPrime(2));
        assertTrue(cr.isPrime(3));
        assertTrue(cr.isPrime(499));
        assertTrue(cr.isPrime(2749));
    }

    @Test
    public void testIsPrimeFalse() {
        assertFalse(cr.isPrime(10));
        assertFalse(cr.isPrime(1));
        assertFalse(cr.isPrime(3170));
    }

    @Test
    public void testIsStringPalindromeTrue() {
        assertTrue(cr.isStringPalindrome("Kayak"));
        assertTrue(cr.isStringPalindrome("101"));
        assertTrue(cr.isStringPalindrome("i did, did i"));
    }

    @Test
    public void testIsStringPalindromeFalse() {
        assertFalse(cr.isStringPalindrome("hello world"));
        assertFalse(cr.isStringPalindrome("java is fun"));
        assertFalse(cr.isStringPalindrome("if this is true i'll eat my hat"));
    }

    @Test
    public void testPrintPrimeNumbers() {
        assertEquals("2 3 5 7 11 13 17 19", cr.printPrimeNumbers(20));
        assertEquals("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101", cr.printPrimeNumbers(101));
        assertEquals("2 3 5 7", cr.printPrimeNumbers(8));
    }

    @Test
    public void testPrintPrimeNumbersNoPrimeNumbersFound() {
        assertEquals("No prime number found", cr.printPrimeNumbers(1));
        assertEquals("No prime number found", cr.printPrimeNumbers(0));
        assertEquals("No prime number found", cr.printPrimeNumbers(-1));
    }

    @Test
    public void testSimpleMultiplicationTable() {
        String result = cr.simpleMultiplicationTable(1);
        if (result.contains(" \n")) {
            fail("Your output table has one or more extra spaces before the newline character. You can use the trim() function to remove additional spaces");
        }
        assertEquals("1", result);

        result = cr.simpleMultiplicationTable(2);
        if (result.contains(" \n")) {
            fail("Your output table has one or more extra spaces before the newline character. You can use the trim() function to remove additional spaces");
        }
        assertEquals("1 2\n2 4", result);

        final String timesSeven = "1 2 3 4 5 6 7\n"
                + "2 4 6 8 10 12 14\n"
                + "3 6 9 12 15 18 21\n"
                + "4 8 12 16 20 24 28\n"
                + "5 10 15 20 25 30 35\n"
                + "6 12 18 24 30 36 42\n"
                + "7 14 21 28 35 42 49";

        result = cr.simpleMultiplicationTable(7);
        if (result.contains(" \n")) {
            fail("Your output table has one or more extra spaces before the newline character. You can use the trim() function to remove additional spaces");
        }
        assertEquals(timesSeven, result);
    }
}