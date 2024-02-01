import org.junit.Test;

import static org.junit.Assert.*;


public class StudentTest {
    private static final double GRADE_TOLERANCE = 0.05;

    @Test
    public void test() throws StudentNameFormatException {
        final String firstStudentName = "Jane Doe";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());
        assertEquals("Jane", firstStudent.getFirstName());
        assertEquals("Doe", firstStudent.getLastName());
        assertEquals("", firstStudent.getMiddleName());

        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());
        assertEquals(firstStudentName, firstStudent.getName());
        assertEquals("", secondStudent.getFirstName());
        assertEquals("Blow", secondStudent.getLastName());
        assertEquals("", secondStudent.getMiddleName());

        final String thirdStudentName = "Raymond Douglas Davies";
        Student thirdStudent = new Student(thirdStudentName);
        assertEquals(thirdStudentName, thirdStudent.getName());
        assertEquals("Raymond", thirdStudent.getFirstName());
        assertEquals("Davies", thirdStudent.getLastName());
        assertEquals("Douglas", thirdStudent.getMiddleName());
    }

    @Test
    public void testStudentStatus() throws StudentNameFormatException {
        Student student  = new Student("a");
        assertEquals(0, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());
        
        student.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        assertTrue(student.isFullTime());
    }
    @Test
        public void testInState() throws StudentNameFormatException {
        Student student = new Student("a");
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }
    @Test
    public void testCalculateGpa() throws StudentNameFormatException {
        Student student = new Student("a");
        assertGpa(student, 0.0);
        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);
        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);
        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);
        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);
        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0 );
    }
    private void assertGpa(Student student, double expectedGpa) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }
    @Test
    public void testCalculateHonorsStudentGpa() throws StudentNameFormatException {
        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(), 5.0);
        assertGpa(createHonorsStudent(), 4.0);
        assertGpa(createHonorsStudent(), 3.0);
        assertGpa(createHonorsStudent(), 2.0);
        assertGpa(createHonorsStudent(), 0.0);
    }

    private Student createHonorsStudent() throws StudentNameFormatException {
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }
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