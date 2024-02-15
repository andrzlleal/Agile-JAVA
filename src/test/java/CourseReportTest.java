import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CourseReportTest {

    @Test public void testReport(){
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(create("ENGL", "101", date));
        report.add(create("CZEC", "200", date));
        report.add(create("ITAL", "410", date));
        report.add(create("CZEC", "220", date));
        report.add(create("ITAL", "330", date));

        assertEquals(
                String.format(
                                "CZEC 200%n" +
                                "CZEC 220%n" +
                                "ENGL 101%n" +
                                "ITAL 330%n" +
                                "ITAL 410%n"),
                report.text());
    }

    private CourseSession create(String name, String number, Date date) {
        return (CourseSession) CourseSession.create(new Course(name, number), date);
    }

}
