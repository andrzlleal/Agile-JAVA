import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class CourseSession {
    private final String department;
    private final String number;
    private final java.util.ArrayList<Student> students = new java.util.ArrayList<>();
    private final Date startDate;

    static  final String NEWLINE =
            System.getProperty("line.separator");
    static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
    static final String ROSTER_REPORT_FOOTER = NEWLINE + "#students = ";

    CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }
    String getDepartment() {
        return department;
    }
    String getNumber(){
        return number;
    }
    int getNumberOfStudents() {
        return students.size();
    }

    Date getStartDate(){
        return startDate;
    }
    Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        final int sessionLength = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;
        int numberOfDays =
                sessionLength * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
    void enroll(Student student) {
        students.add(student);
    }
    Student get(int index) {
        return students.get(index);
    }



     /*   Student student = students.get(0);
        buffer.append(student.getName());
        buffer.append(NEWLINE);

        student = students.get(1);
        buffer.append(student.getName());
        buffer.append(NEWLINE);
    */

    ArrayList<Student> getAllStudents() {
        return students;
    }

}
