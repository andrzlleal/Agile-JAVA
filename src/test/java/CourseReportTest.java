import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CourseReportTest {

    @Test public void testReport(){
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));
        report.add(CourseSession.create("CZEC", "220", date));
        report.add(CourseSession.create("ITAL", "330", date));

        assertEquals("CZEC200" + ReportConstant.NEWLINE +
                        "CZEC220" + ReportConstant.NEWLINE +
                        "ENGL101" + ReportConstant.NEWLINE +
                        "ITAL330" + ReportConstant.NEWLINE +
                        "ITAL410" + ReportConstant.NEWLINE,
                report.text());
    }

}
