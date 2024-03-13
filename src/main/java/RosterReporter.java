import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

class RosterReporter {
    static final String ROSTER_REPORT_HEADER = "Student%n-%n";
    static final String ROSTER_REPORT_FOOTER = "%n# students = %d%n";
    private final Session session;
    private Writer writer;

    RosterReporter(CourseSession session) {
        this.session = session;
    }
    void writeReport(String filename) throws IOException {Writer bufferedWriter =
            new BufferedWriter(new FileWriter(filename));
        try {
            writeReport(bufferedWriter.toString());
        }
        finally {
            bufferedWriter.close();
        }
    }
        void writeHeader() throws IOException {
            writer.write(String.format(ROSTER_REPORT_HEADER));
        }
        void writeBody() throws IOException {
            for (Student student : session.getAllStudents()) {
               writer.write(String.format(student.getName() + "%n"));
            }
        }
        void writeFooter() throws IOException {
            writer.write(String.format(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + "%n"));
        }
}