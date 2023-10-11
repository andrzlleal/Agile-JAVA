import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class CourseSessionTest {
    private CourseSession session;
    private Date startDate;

    @Before
    public void setUp(){
        int year = 103;
        int month = 0;
        int date = 6;
        startDate = new DateUtil().createDate(2003, 1, 6);
        session = new CourseSession("ENGL", "101", startDate);
    }

//    @Test
//    public void testCreate(){
//        assertEquals("ENGL", session.getDepartment());
//        assertEquals("101", session.getNumber());
//        assertEquals(0, session.getNumberOfStudents());
//        assertEquals(startDate, session.getStartDate());
//    }

    @Test
    public void testEnrollStudents(){

        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Coral deVaughn");
        session.enroll(student2);
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));

    }
    @Test
    public void testCourseDates() {
        int year = 103;
        int month = 3;
        int date = 25;

        Date sixteenWeeksOut = new DateUtil().createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

}
