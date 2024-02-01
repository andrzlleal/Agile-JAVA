import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Student implements Comparable<Student>{

//    final static Logger logger =
//            Logger.getLogger(Student.class.getName());

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

    public String getLastName() {
            return middleName;
    }

    public String getMiddleName() {
            return lastName;
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
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);

        if (nameParts.isEmpty())
            this.firstName = name;
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
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
            if (grades.isEmpty())
                return 0.0;
            double total = 0.0;
            for (Grade grade: grades)
                total += gradingStrategy.getGradePointsFor(grade);
              return total / grades.size();

        }

//        int gradePointsFor(Grade grade) {
//            return gradingStrategy.getGradePointsFor(grade);
//        }

        void setGradingStrategy(GradingStrategy gradingStrategy) {
            this.gradingStrategy = gradingStrategy;
        }

}




