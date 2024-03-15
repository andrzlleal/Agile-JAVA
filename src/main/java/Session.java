import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

abstract public class Session
        implements Comparable<Session>,
        Iterable<Student>,
        java.io.Serializable {
    public static final long serialVersionUID = 1L;
    private String name;
    private static int count;
    private Course course;
    private final Date startDate;
    private int numberOfCredits;
    //private final Vector<Student> students = new Vector<Student>();
    private URL url;
    private transient List<Student> students = new ArrayList<Student>();

    public Iterator<Student> iterator() {
        return students.iterator();
    }

//    double averageGpaForPartTimeStudents() {
//        double total = 0.0;
//        int count = 0;
//        for (Enumeration<Student> it = students.elements();
//             it.hasMoreElements(); ) {
//            Student student = it.nextElement();
//            if (student.isFullTime())
//                continue;
//            count++;
//            total += student.getGpa();
//        }
//        if (count == 0) return 0.0;
//        return total / count;
//    }

    protected Session(Course course, Date startDate) {
        this.course = course;
        this.startDate = startDate;
    }

    public int compareTo(Session that) {
        int compare =
                this.getDepartment().compareTo(that.getDepartment());
        if (compare != 0)
            return compare;
        return this.getNumber().compareTo(that.getNumber());
    }

    void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getDepartment() {
        return course.getDepartment();
    }

    public String getNumber() {
        return course.getNumber();
    }

    int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }

    protected Date getStartDate() {
        return startDate;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    abstract protected int getSessionLength();

    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;
        int numberOfDays =
                getSessionLength() * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
    public void setUrl(String urlString) throws SessionException {
        try {
            this.url = new URL(urlString);
        } catch (MalformedURLException e) {
            log(e);
            throw new SessionException(e);
        }
    }

    private void log(Exception e) {
    }

    public URL getUrl() {
        return url;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }
    @Serial
    private void writeObject(ObjectOutputStream output)
            throws IOException {
        output.defaultWriteObject();
        output.writeInt(students.size());
        for (Student student: students)
            output.writeObject(student.getLastName());
    }
    private void readObject(ObjectInputStream input)
            throws Exception {
        input.defaultReadObject();
        students = new ArrayList<Student>();
        int size = input.readInt();
        for (int i = 0; i < size; i++) {
            String lastName = (String) input.readObject();
            students.add(Student.findByLastName(lastName));
        }
    }

}
