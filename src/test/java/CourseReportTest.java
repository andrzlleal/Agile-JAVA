import org.junit.Test;

import java.util.Collections;
import java.util.Date;


import static jdk.xml.internal.SecuritySupport.NEWLINE;
import static org.junit.Assert.assertEquals;

public class CourseReportTest {

    @Test public void testReport(){
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));

        assertEquals( "CZEC 200" + NEWLINE + "ENGL 101" + NEWLINE + "ITAL 410" + NEWLINE, report.text());
    }
//    @Test
//    public String text() {
//        Collections.sort(sessions);
//        StringBuilder builder = new StringBuilder();
//        for (CourseSession session : sessions)
//            builder.append(
//                    session.getDepartment() + " " +
//                            session.getNumber() + NEWLINE);
//        return builder.toString();
    }
}
