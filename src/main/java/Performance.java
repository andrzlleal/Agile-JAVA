public class Performance {
    private int[] tests;
    public void setNumberOfTests(int numberOfTests) {
        tests = new int[numberOfTests];
    }
    public void set(int testNumber, int score) {
        tests[testNumber] = score;
    }
    public int get(int testNumber) {
        return tests[testNumber];
    }
    public double average() {
        double total = 0.0;
        for (int test : tests) total += test;
        return total / tests.length;
    }
    public void setScores(int... tests) {
        this.tests = tests;
    }
}

