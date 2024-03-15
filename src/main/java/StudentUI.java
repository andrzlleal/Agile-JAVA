import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentUI {
    static final String MENU = "(A)dd or (Q)uit? ";
    static final String ADD_OPTION = "A";
    static final String QUIT_OPTION = "Q";
    static final String NAME_PROMPT = "Name: ";
    static final String ADDED_MESSAGE = "Added";

    private final BufferedReader reader;
    private final BufferedWriter writer;
    private final List<Student> students = new ArrayList<>();
    public StudentUI(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public void run() throws IOException, StudentNameFormatException {
        String line;
        do {
            write(MENU);
            line = reader.readLine();
            if (line.equals(ADD_OPTION))
                addStudent();
        } while (!line.equals(QUIT_OPTION));
    }
    List<Student> getAddedStudents() {
        return students;
    }
    private void addStudent() throws IOException, StudentNameFormatException {
        write(NAME_PROMPT);
        String name = reader.readLine();
        students.add(new Student(name));
        writeln();
    }
    private void write(String line) throws IOException {
        writer.write(line, 0, line.length());
        writer.flush();
    }
    private void writeln () throws IOException {
        write(StudentUI.ADDED_MESSAGE);
        writer.newLine();
        writer.flush();
    }
    public StudentUI() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public static void main(String[] args) throws IOException, StudentNameFormatException {
        new StudentUI().run();
    }
}
