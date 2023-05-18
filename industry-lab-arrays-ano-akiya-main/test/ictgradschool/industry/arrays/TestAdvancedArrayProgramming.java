package ictgradschool.industry.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestAdvancedArrayProgramming {
    AdvancedArrayProgramming exercises;

    @BeforeEach
    void setUp() throws Exception {
        exercises = new AdvancedArrayProgramming();
    }

    @Test
    public void testGetPairSumTo() {
        assertEquals("4, 6", exercises.getPairSumTo(new int[]{1, 2, 3, 4, 5, 6}, 10));
        assertEquals("0", exercises.getPairSumTo(new int[]{1, 2, 3, 4, 5}, 10));
        assertEquals("8", exercises.getPairSumTo(new int[]{8}, 8));
        assertEquals("-10, 2", exercises.getPairSumTo(new int[]{-10, 2, 39, 14, 70, 5}, -8));
        assertEquals("2, 3", exercises.getPairSumTo(new int[]{2, 3}, 5));
        assertEquals("0, 3", exercises.getPairSumTo(new int[]{0, 1, 3}, 3));
    }

    @Test
    public void testRemoveDuplicates() {
        assertArrayEquals(new String[]{"abc", "123"}, exercises.removeDuplicates(new String[]{"abc", "123"}));
        assertArrayEquals(new String[]{"abc"}, exercises.removeDuplicates(new String[]{"abc"}));
        assertArrayEquals(new String[]{"hello", "goodbye"}, exercises.removeDuplicates(new String[]{"hello", "goodbye", "hello", "hello"}));
        assertArrayEquals(new String[]{"blah"}, exercises.removeDuplicates(new String[]{"blah", "blah", "blah", "blah"}));
    }

    @Test
    public void testFindCommonNumbers() {
        assertArrayEquals(new int[]{2, 4}, exercises.findCommonNumbers(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 2, 4}));
        assertArrayEquals(new int[]{}, exercises.findCommonNumbers(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10}));
        assertArrayEquals(new int[]{43}, exercises.findCommonNumbers(new int[]{-1, 79, 43, 5}, new int[]{6, -79, 1, -5, 43}));
        assertArrayEquals(new int[]{}, exercises.findCommonNumbers(new int[]{1}, new int[]{2}));
        assertArrayEquals(new int[]{100, 2}, exercises.findCommonNumbers(new int[]{100, 2}, new int[]{2, 100}));
    }

    @Test
    public void testConvertIntToBinary() {
        assertEquals("100", exercises.convertIntToBinary(4));
        assertEquals("0", exercises.convertIntToBinary(0));
        assertEquals("1100100", exercises.convertIntToBinary(100));
        assertEquals("11", exercises.convertIntToBinary(3));
        assertEquals("1000", exercises.convertIntToBinary(8));
    }
}
