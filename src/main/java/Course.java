public class Course implements java.io.Serializable{
    private final String department;
    private final String number;
    public Course(String department, String number) {
        this.department = department;
        this.number = number;
    }
    public String getDepartment() {
        return department;
    }
    public String getNumber() {
        return number;
    }
    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (!(object instanceof Course))
            return false;
        Course that = (Course)object;
        return
                this.department.equals(that.department) &&
                this.number.equals(that.number);
    }
    @Override
    public int hashCode() {
        final int hashMultiplier = 41;
        int result = 71;
        result  = result * hashMultiplier + department.hashCode();
        result = result * hashMultiplier + number.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return department + " " + number;
    }
}
