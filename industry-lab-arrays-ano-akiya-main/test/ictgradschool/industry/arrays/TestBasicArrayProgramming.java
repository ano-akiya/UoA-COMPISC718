package ictgradschool.industry.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestBasicArrayProgramming {
    BasicArrayProgramming exercises;
    @BeforeEach
    void setUp() throws Exception {
        exercises = new BasicArrayProgramming();
    }

    @Test
    public void testGetHighestInt(){
        assertEquals(7, exercises.getHighestInt(new int[] {2, 3, 4, 7}));
        assertEquals(53, exercises.getHighestInt(new int[] {12, 3, 47, 53, 23, 45}));
        assertEquals(999, exercises.getHighestInt(new int[] {865, 123, 47, 999, 345, 245, 145}));
    }

    @Test
    public void testGetAverage(){
        assertEquals(15.0, exercises.getAverage(new double[]{10.0, 12.0, 15.0, 23.0}));
        assertEquals(597.5, exercises.getAverage(new double[]{123.0, 456.0, 824.0, 987.0}));
    }

    @Test
    public void testGetCumulativeValues(){
        double[] expectedArray = new double[]{3.0, 8.0, 10.5};
        assertArrayEquals(expectedArray, exercises.getCumulativeValues(new double[]{3.0, 5.0, 2.5}));
    }
}
