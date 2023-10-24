import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class CourseSessionTest extends TestCase {
    private CourseSession session;
    private Date startDate;
    private static final int CREDITS = 3;

    @Before
    public void setUp(){
        Date startDate = new GregorianCalendar(2003, Calendar.JANUARY, 6).getTime();
        session = createCourseSession();
    }

    private CourseSession createCourseSession() {
        CourseSession session =
                CourseSession.create("ENGL", "101", startDate);
        session.setNumberOfCredits(CourseSessionTest.CREDITS);
        return session;
    }

    @Test
    public void testEnrollStudents(){

        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Coral deVaughn");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }
    @Test
        public void testCourseDates() {
            Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
            assertEquals(sixteenWeeksOut, session.getEndDate());
    }
    @Test
        public void testCount(){
            CourseSession.resetCount();
            testCreateCourseSession();
            assertEquals(1, CourseSession.getCount());
            testCreateCourseSession();
            assertEquals(2, CourseSession.getCount());
    }
////tem algo errado aqui
    private void testCreateCourseSession() {
    }

}

