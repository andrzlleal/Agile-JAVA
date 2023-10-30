import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        StudentTest.class,
        CourseSessionTest.class,
        RosterReporterTest.class,
        DateUtilTest.class,
        CourseReportTest.class
})
public class AllTests {
}