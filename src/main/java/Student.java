import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public class Student implements Comparable<Student>{

    public static final int MAX_NAME_PARTS = 3;
    final static Logger logger = Logger.getLogger(Student.class.getName());
    private static int settings = 0x0;

    private final String name;
        private int credits;
        static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
        private String firstName = "";
        private String middleName = "";
        private String lastName;

        static final String IN_STATE = "CO";

        private String state = "";

        private final ArrayList<Grade> grades = new ArrayList<Grade>();

        void setState(String state) {
            this.state = state;
        }

        public void addGrade(Grade grade) {
            grades.add(grade);
        }
        static final String TOO_MANY_NAME_PARTS_MSG =
            "Student name '%s' contains more than %d parts";
    @Override
    public int compareTo(Student o) {
        return 0;
    }

    public String getFirstName() {
            return firstName;
    }

    public String getLastName() { return lastName; }

    public String getMiddleName() {
            return middleName;
    }

    public void setId(String id) {
    }

    public String getId() {
        return null;
    }

    public enum Grade {
            A(4),
            B(3),
            C(2),
            D(1),
            F(0);

        Grade(int points) {
        }

    }
//
//    public int totalCharges() {
//        int total = 0;
//        for (Integer charge: charges)
//            total += charge;
//        return total;
//    }

    public Student(String fullName) throws StudentNameFormatException {
        this.name = fullName;
        credits = 0;
        List<String> nameParts = split(fullName);
        if (nameParts.size() > MAX_NAME_PARTS) {
            String message =
                    String.format(Student.TOO_MANY_NAME_PARTS_MSG,
                            fullName, MAX_NAME_PARTS);
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }

    private List<String> split(String fullName) {
        List<String> results = new ArrayList<String>();
        Collections.addAll(results, fullName.split(" "));
        return results;
    }

    private void setName(List<String> nameParts) {
        if (nameParts.isEmpty()) {
            this.firstName = "";
            this.middleName = "";
            this.lastName = "";
        } else if (nameParts.size() == 1) {
            this.firstName = nameParts.getFirst();
            this.middleName = "";
            this.lastName = "";
        } else if (nameParts.size() == 2) {
            this.firstName = nameParts.get(0);
            this.middleName = "";
            this.lastName = nameParts.get(1);
        } else {
            this.firstName = nameParts.getFirst();
            this.middleName = String.join(" ", nameParts.subList(1, nameParts.size() - 1));
            this.lastName = nameParts.getLast();
        }
    }
        private String removeLast(List<String> list) {
            if(list.isEmpty())
                return "";
            return list.removeLast();
        }

        public String getName() {
            return name;
        }

        boolean isFullTime() {
            return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
        }

        int getCredits() {
            return credits;
        }

        void addCredits(int credits) {
            this.credits += credits;
        }

        public boolean isInState() {
            return state.equals(Student.IN_STATE);
    }
        private GradingStrategy gradingStrategy = new BasicGradingStrategy();

        double getGpa() {
            Student.logger.fine("begin getGpa" + System.currentTimeMillis());
            if (grades.isEmpty())
                return 0.0;
            double total = 0.0;
            for (Grade grade: grades)
                total += gradingStrategy.getGradePointsFor(grade);
              double result = total / grades.size();
              Student.logger.fine("end Gpa " + System.currentTimeMillis());
              return result;

        }

        void setGradingStrategy(GradingStrategy gradingStrategy) {
            this.gradingStrategy = gradingStrategy;
        }

        public enum Flag {
            ON_CAMPUS(1),
            TAX_EXEMPT(2),
            MINOR(4),
            TROUBLEMAKER(8) ;

            private final int mask;

            Flag(int mask) {
                this.mask = mask;
            }
        }
        public static void set(Flag... flags) {
            for (Flag flag: flags)
                settings |= flag.mask;
        }
        public void unset(Flag... flags) {
            for (Flag flag: flags)
                settings &= ~flag.mask;
        }
        public boolean isOn(Flag flag) {
            return (settings & flag.mask) == flag.mask;
        }
        public boolean isOff(Flag flag) {
            return !isOn(flag);
        }



}




