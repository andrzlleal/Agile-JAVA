import org.junit.Test;

import java.util.Date;

import static com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl.createDate;
import static org.junit.Assert.assertEquals;

public class CourseSessionTest extends SessionTest {
    @Test
        public void testCourseDates() {
            Date startDate = DateUtil.createDate(2003, 1, 6);
            Session session = createSession(createCourse(), startDate);
            Date sixteenWeeksOut = createDate(2003, 4, 25);
            assertEquals(sixteenWeeksOut, session.getEndDate());
        }

    @Test
        public void testCount() {
            CourseSession.resetCount();
            createSession(createCourse(), new Date());
            assertEquals(1, CourseSession.getCount());
            createSession(createCourse(), new Date());
            assertEquals(2, CourseSession.getCount());
        }

    private Course createCourse() {
        return new Course("ENGL", "101");
    }

    @Override
    protected Session createSession(Course course, Date date) {
        return CourseSession.create(course, date);
    }
}


