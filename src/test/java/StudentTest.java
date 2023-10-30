import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private static final double GRADE_TOLERANCE = 0.05;

    @Test
    public void test() {
        final String firstStudentName = "Jane Doe";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());

        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());

        assertEquals(firstStudentName, firstStudent.getName());

    }
    @Test
    public void testStudentStatus() {
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
        public void testInState() {
        Student student = new Student("a");
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }
    @Test
    public void testCalculateGpa() {
        Student student = new Student("a");
        assertEquals(0.0, student.getGpa(), GRADE_TOLERANCE);
        student.addGrade("A");
        assertEquals(4.0, student.getGpa(), GRADE_TOLERANCE);
        student.addGrade("B");
        assertEquals(3.5, student.getGpa(), GRADE_TOLERANCE);
        student.addGrade("C");
        assertEquals(3.0, student.getGpa(), GRADE_TOLERANCE);
        student.addGrade("D");
        assertEquals(2.5, student.getGpa(), GRADE_TOLERANCE);
        student.addGrade("F");
        assertEquals(2.0, student.getGpa(), GRADE_TOLERANCE);
    }


}