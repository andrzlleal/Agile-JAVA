package lesson10;

public class DivisibleByThree {

    public static int[] filterUsingModulus(int... numbers) {
        return filter(numbers, true);
    }

    public static int[] filterUsingDivisionAndMultiplication(int... numbers) {
        return filter(numbers, false);
    }

    private static int[] filter(int[] numbers, boolean useModulus) {
        int count = 0;
        for (int number : numbers) {
            if ((useModulus && number % 3 == 0) || (!useModulus && number / 3 * 3 == number)) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int number : numbers) {
            if ((useModulus && number % 3 == 0) || (!useModulus && number / 3 * 3 == number)) {
                result[index++] = number;
            }
        }
        return result;
    }
}
