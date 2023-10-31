import java.util.ArrayList;

public class Student implements Comparable<Student>{
        private final String name;
        private int credits;
        static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

        static final String IN_STATE = "CO";

        private String state = "";

        private final ArrayList<Grade> grades = new ArrayList<Grade>();

        void setState(String state) {
            this.state = state;
        }

        void addGrade(Grade grade) {
            grades.add(grade);
        }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    enum Grade{A, B, C, D, F};

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

        private GradingStrategy gradingStrategy = new RegularGradingStrategy();


        double getGpa() {
            if (grades.isEmpty())
                return 0.0;
            double total = 0.0;
            for (Grade grade: grades)
                total += gradingStrategy.getGradePointsFor(grade);
              return total / grades.size();

        }

        int gradePointsFor(Grade grade) {
            return gradingStrategy.getGradePointsFor(grade);
        }

        void setGradingStrategy(GradingStrategy gradingStrategy) {
            this.gradingStrategy = gradingStrategy;
        }


}




