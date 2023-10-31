import java.util.ArrayList;
import java.util.Collections;


public class CourseReport {
private final ArrayList<CourseSession> sessions =
        new ArrayList<CourseSession>();

public void add(CourseSession session) {
    sessions.add(session);
}

public String text() {
    Collections.sort(sessions);
    StringBuilder builder = new StringBuilder();
    for (CourseSession session : sessions)
        builder.append(session.getDepartment()).append(session.getNumber()).append(ReportConstant.NEWLINE);
    return builder.toString();

}

}


