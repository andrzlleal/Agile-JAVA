package lesson10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MathOperationsTest {
    @Test
    public void testDivisionByZeroToInfinity() {
        double result = 1.0 / 0.0;
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0);
    }
    @Test
    public void testZeroDivideByZeroToNan() {
        double result = 0.0 / 0.0;
        assertTrue(Double.isNaN(result));
    }
    @Test
    public void testSquareRootOfNegativeNumberToNan() {
        double result = Math.sqrt(-1.0);
        assertTrue(Double.isNaN(result));
    }
    @Test
    public void testSumOfInfinityAndFiniteNumber() {
        double result = Double.POSITIVE_INFINITY + 5.0;
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0);
    }
    @Test
    public void testMultiplicationOfInfinityByZero() {
        double result = Double.POSITIVE_INFINITY * 0.0;
        assertTrue(Double.isNaN(result));
    }

}
