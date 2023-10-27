import java.util.ArrayList;

import static jdk.xml.internal.SecuritySupport.NEWLINE;

public class CourseReport {
private final ArrayList<CourseSession> sessions =
        new ArrayList<CourseSession>();

public void add(CourseSession session) {
    sessions.add(session);
}
public String text() {
    StringBuilder builder = new StringBuilder();
    for (CourseSession session : sessions)
        builder.append(session.getDepartment()).append(session.getNumber()).append(NEWLINE);
    return builder.toString();

}
}


