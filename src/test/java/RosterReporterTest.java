import org.junit.Test;


public class RosterReporterTest{
    @Test
        public void testRosterReport() {
            Session session =
                    CourseSession.create(
                            new Course("ENGL", "101"),
                            DateUtil.createDate(2003, 1, 6));

        }
//    @Test
//    public Date createDate() {
//        GregorianCalendar calendar = new GregorianCalendar();
//        calendar.clear();
//        calendar.set(Calendar.YEAR, year);
//        calendar.set(Calendar.MONTH, month - 1);
//        calendar.set(Calendar.DAY_OF_MONTH, date);
//        return calendar.getTime();
//    }
}