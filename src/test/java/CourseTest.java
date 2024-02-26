import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest{

    @Test
    public void testCreate() {
        Course course = new Course("CMSC", "120");
        assertEquals("CMSC", course.getDepartment());
        assertEquals("120", course.getNumber());
    }
    @Test
    public void testEquality() {
        Course courseA = new Course("NURS", "201");
        Course courseAPrime = new Course("NURS", "201");
        assertEquals(courseA, courseAPrime);

        Course courseB = new Course("ARTH", "330");
        assertNotEquals(courseA, courseB);

        assertEquals(courseA, courseA);

        Course courseAPrime2 = new Course("NURS", "201");
        assertEquals(courseAPrime, courseAPrime2);
        assertEquals(courseA, courseAPrime2);

        assertEquals(courseAPrime, courseA);
        assertEquals(courseA, courseAPrime);
        assertFalse(courseA.equals(null));

        assertFalse(courseA.equals("CMSC-120"));
    }
    @Test
    public void testHashCode(){
        Course courseA = new Course("NURS", "201");
        Course courseAPrime = new Course("NURS", "201");

        assertEquals(courseA.hashCode(), courseAPrime.hashCode());
        assertEquals(courseA.hashCode(), courseAPrime.hashCode());
    }
    @Test
    public void testToString() {
        Course course = new Course("ENGL", "301");
        assertEquals("Course: ENGL 301", "Course: " + course);
    }


}