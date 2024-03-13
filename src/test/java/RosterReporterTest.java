import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RosterReporterTest {
    private Session session;

    protected void setUp() throws StudentNameFormatException {
        session =
                CourseSession.create(
                        new Course("ENGL", "101"),
                        DateUtil.createDate(2003, 1, 6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
    }

    @Test
    public void testRosterReport() throws IOException {
        Writer writer = new StringWriter();
        new RosterReporter((CourseSession) session).writeReport(writer.toString());
        assertReportContents(writer.toString());
    }

    private void assertReportContents(String rosterReport) {
        assertEquals(
                String.format(RosterReporter.ROSTER_REPORT_HEADER +
                                "A%n" +
                                "B%n" + RosterReporter.ROSTER_REPORT_FOOTER,
                        session.getNumberOfStudents()),
                rosterReport);
    }

    @Test
    public void testFiledReport() throws IOException {
        final String filename = "testFiledReport.txt";
        try {
            delete(filename);
            new RosterReporter((CourseSession) session).writeReport(filename);
            StringBuilder buffer = new StringBuilder();
            String line;
            BufferedReader reader =
                    new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null)
                buffer.append(String.format(line + "%n"));
            reader.close();
            assertReportContents(buffer.toString());
        } finally {
            delete(filename);
        }
    }
        private void delete (String filename){
            File file = new File(filename);
            if (file.exists())
                assertTrue("unable to delete " + filename, file.delete());
        }
}


