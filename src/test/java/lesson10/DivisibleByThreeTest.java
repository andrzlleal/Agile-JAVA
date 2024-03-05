package lesson10;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class DivisibleByThreeTest {
    @Test
    public void testModulusOperator() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = {3, 6, 9};

        assertArrayEquals(expected, DivisibleByThree.filterUsingModulus(input));
    }

    @Test
    public void testDivisionAndMultiplicationOperators() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = {3, 6, 9};

        assertArrayEquals(expected, DivisibleByThree.filterUsingDivisionAndMultiplication(input));
    }
}