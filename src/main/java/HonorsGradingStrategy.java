public class HonorsGradingStrategy extends BasicGradingStrategy implements GradingStrategy {
    public int getGradePointsFor(Student.Grade grade) {
        int points = super.basicGradePointsFor(grade);
        if (points > 0)
            points += 1;
        return points;
    }

}
