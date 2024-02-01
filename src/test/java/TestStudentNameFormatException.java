import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestStudentNameFormatException {
    @Test
    public void testBadlyFormattedName() {
        try {
            new Student("a b c d");
            fail("expected exception from 4-part name");
        }
        catch (StudentNameFormatException expectedException) {
            assertEquals("Student name 'a b c d' contains more than 3 parts", expectedException.getMessage());
        }
    }
}
