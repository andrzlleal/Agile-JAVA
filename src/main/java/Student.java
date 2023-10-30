import java.util.ArrayList;

public class Student {
        private final String name;
        private int credits;
        static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

        static final String IN_STATE = "CO";

        private String state = "";

        private ArrayList<String> grades = new ArrayList<String>();

        void setState(String state) {
            this.state = state;
        }

        void addGrade(String grade) {
            grades.add(grade);
        }

        public Student(String name) {
            this.name = name;
            credits = 0;
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

        double getGpa() {
            if (grades.isEmpty())
                return 0.0;
            double total = 0.0;
            for (String grade: grades)
                total += gradePointsFor(grade);
              return total / grades.size();

    }

    private double gradePointsFor(String grade) {
            if (grade.equals("A"))
                return 4;
            else if (grade.equals("B"))
                return 3;
            else if (grade.equals("C"))
                return 2;
            else if (grade.equals("D"))
                return 1;
            return 0;
        }
}




