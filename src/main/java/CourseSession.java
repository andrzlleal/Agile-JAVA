import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession{
    private final java.util.ArrayList<Student> students = new java.util.ArrayList<>();
    private final Date startDate;
    private final String department;
    private final String number;

    static void resetCount() {
        count = 0;
    }
    static int getCount() {
        return count;
    }
    private static void incrementCount() {
       count++;
    }
    public static int count;
    private int numberOfCredits;
    void setNumberOfCredits(int numberOfCredits){
        this.numberOfCredits = numberOfCredits;
    }
    
    CourseSession(String department, String number, Date startDate){
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    int getNumberOfStudents() {
        return students.size();
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
        student.addCredits(numberOfCredits);
        students.add(student);
    }
    Student get(int index) {
        return students.get(index);
    }
    ArrayList<Student> getAllStudents() {
        return students;
    }
    public static CourseSession create(
            String department,
            String number,
            Date startDate) {
        incrementCount();
        return new CourseSession(department, number, startDate);
    }
}
