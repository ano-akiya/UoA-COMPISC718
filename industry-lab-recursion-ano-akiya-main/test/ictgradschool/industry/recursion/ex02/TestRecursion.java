package ictgradschool.industry.recursion.ex02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the methods in Recursion class.
 */
class TestRecursion {
    private PipedInputStream pIn;
    private PipedOutputStream pOut;
    private BufferedReader reader;

    private PrintStream oldOut;

    private Recursion ex;

    @BeforeEach
    void setUp() throws IOException {
        this.ex = new Recursion();

        oldOut = System.out;

        // Hack so we can read things that you print using System.out.println
        pIn = new PipedInputStream();
        pOut = new PipedOutputStream(pIn);
        System.setOut(new PrintStream(pOut));
        reader = new BufferedReader(new InputStreamReader(pIn));

    }

    @AfterEach
    void tearDown() throws IOException {
        System.setOut(oldOut);
        reader.close();
        pOut.close();
    }

    @Test
    public void testGetSum() {
        assertEquals(1, ex.getSum(1));
        assertEquals(3, ex.getSum(2));
        assertEquals(6, ex.getSum(3));
        assertEquals(15, ex.getSum(5));
        assertEquals(55, ex.getSum(10));
        assertEquals(210, ex.getSum(20));
    }

    @Test
    public void testGetSmallest() {
        assertEquals(-23, ex.getSmallest(new int[] { 3, -4, -23, 745}, 0, 4));
        assertEquals(10, ex.getSmallest(new int[] { 10, 11, 12, 13, 14, 15}, 0, 6));
        assertEquals(100, ex.getSmallest(new int[] { 104, 103, 102, 101, 100}, 0, 5));
        assertEquals(-4, ex.getSmallest(new int[] { 1869, 21, -4, 1000000, -3}, 0, 5));
    }

    @Test
    public void testPrintNums1() throws IOException {
        ex.printNums1(10);
        assertEquals("10", reader.readLine());
        assertEquals("9", reader.readLine());
        assertEquals("8", reader.readLine());
        assertEquals("7", reader.readLine());
        assertEquals("6", reader.readLine());
        assertEquals("5", reader.readLine());
        assertEquals("4", reader.readLine());
        assertEquals("3", reader.readLine());
        assertEquals("2", reader.readLine());
        assertEquals("1", reader.readLine());

        ex.printNums1(1);
        assertEquals("1", reader.readLine());
    }

    @Test
    public void testPrintNums2() throws IOException {
        ex.printNums2(10);
        assertEquals("1", reader.readLine());
        assertEquals("2", reader.readLine());
        assertEquals("3", reader.readLine());
        assertEquals("4", reader.readLine());
        assertEquals("5", reader.readLine());
        assertEquals("6", reader.readLine());
        assertEquals("7", reader.readLine());
        assertEquals("8", reader.readLine());
        assertEquals("9", reader.readLine());
        assertEquals("10", reader.readLine());

        ex.printNums2(1);
        assertEquals("1", reader.readLine());
    }

    @Test
    public void testCountEs() {
        assertEquals(1, ex.countEs("Hello World"));
        assertEquals(1, ex.countEs("HELLO WORLD"));
        assertEquals(5, ex.countEs("EeeEe"));
        assertEquals(18, ex.countEs("I'm just typing a sentence here. I'll then count the number of E's in it, and then set that as the expected value for this test case."));
    }

    @Test
    public void testFibonacci() {
        assertEquals(0, ex.fibonacci(0));
        assertEquals(1, ex.fibonacci(1));
        assertEquals(1, ex.fibonacci(2));
        assertEquals(2, ex.fibonacci(3));
        assertEquals(3, ex.fibonacci(4));
        assertEquals(5, ex.fibonacci(5));
        assertEquals(8, ex.fibonacci(6));
        assertEquals(13, ex.fibonacci(7));
        assertEquals(21, ex.fibonacci(8));
        assertEquals(34, ex.fibonacci(9));
    }

    @Test
    public void testIsPalindrome() {
        assertEquals(true, ex.isPalindrome("aba"));
        assertEquals(true, ex.isPalindrome("abba"));
        assertEquals(true, ex.isPalindrome("racecar"));
        assertEquals(false, ex.isPalindrome("not a palindrome"));
        assertEquals(true, ex.isPalindrome("1337331"));
        assertEquals(true, ex.isPalindrome("madam"));
        assertEquals(false, ex.isPalindrome("moon"));
        assertEquals(true, ex.isPalindrome("noon"));
        assertEquals(false, ex.isPalindrome("pgcert"));
        assertEquals(true, ex.isPalindrome(""));
        assertEquals(true, ex.isPalindrome("a"));
    }

}