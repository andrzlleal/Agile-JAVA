import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class CourseSession {

    public static final double ROSTER_REPORT_HEADER = 0;
    public static final double ROSTER_REPORT_FOOTER = 0;
    private final String department;
    private final String number;
    private final java.util.ArrayList<Student> students = new java.util.ArrayList<>();
    private Date startDate;

    CourseSession(String department, String number) {
        this.department = department;
        this.number = number;
    }
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
        int numberOfDays = 16 * 7 - 3;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
    void enroll(Student student) {
        students.add(student);
    }
    Student get(int index) {
        return students.get(index);
    }

}
