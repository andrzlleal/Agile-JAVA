package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathTest {
    static final double TOLERANCE = 0.05;
    @Test
    public void testHypotenuse() {
        assertEquals(5.0, Math.hypotenuse(3.0, 4.0), TOLERANCE);
    }
}
