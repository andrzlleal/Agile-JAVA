import java.util.Date;

public class SummerCourseSession extends Session {
    private SummerCourseSession(Course course, Date startDate) {
        super(course, startDate);
    }
    public static Session create(Course course, Date startDate) {
        return new SummerCourseSession(course, startDate);
    }

    protected int getSessionLength() {
        return 8;
    }
}