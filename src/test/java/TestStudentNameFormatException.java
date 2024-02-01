import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestStudentNameFormatException {
    @Test
    public void testBadlyFormattedName() {
        final String studentName = "a b c d";
        try {
            new Student(studentName);
            fail("expected exception from 4-part name");
        }
        catch (StudentNameFormatException expectedException) {
            assertEquals(
                    String.format(Student.TOO_MANY_NAME_PARTS_MSG,
                            studentName, Student.MAX_NAME_PARTS),
                    expectedException.getMessage());
        }
    }
}
