package lesson11Tests;

import lesson11.PrimitiveSizeCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PrimitiveSizeCalculatorTest {
    @Test
    void testPrimitiveSizeCalculation() {
        assertEquals(1, PrimitiveSizeCalculator.getSize((byte) 0));
        assertEquals(2, PrimitiveSizeCalculator.getSize((short) 0));
        assertEquals(4, PrimitiveSizeCalculator.getSize(0));
        assertEquals(8, PrimitiveSizeCalculator.getSize(0L));
        assertEquals(4, PrimitiveSizeCalculator.getSize(0.0f));
        assertEquals(8, PrimitiveSizeCalculator.getSize(0.0));
        assertEquals(2, PrimitiveSizeCalculator.getSize((char) 0));
        assertEquals(1, PrimitiveSizeCalculator.getSize(false));
    }
}