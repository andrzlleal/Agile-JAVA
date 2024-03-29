import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordGeneratorTest {
    @Test
    public void testGeneratePassword() {
        PasswordGenerator generator = new PasswordGenerator();
        generator.setRandom(new MockRandom('A'));
        assertEquals("ABCDEFGH", generator.generatePassword());
        generator.setRandom(new MockRandom('C'));
        assertEquals("CDEFGHIJ", generator.generatePassword());
    }
    static class MockRandom extends java.util.Random {
        private int i;
        MockRandom(char startCharValue) {
            i = startCharValue - PasswordGenerator.LOW_END_PASSWORD_CHAR;
        }
        protected int next(int bits) {
            return i++;
        }
    }
}
