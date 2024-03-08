package lesson10;

public class ShiftExample {
    public static void main(String[] args) {
        //numero positivo
        int positiveNumber = 16;

        int resultRightShiftPositive = positiveNumber >> 1;

        int resultUnsignedRightShiftPositive = positiveNumber >>> 1;

        //numero negativo
        int negativeNumber = -16;

        int resultRightShiftNegative = negativeNumber >> 1;

        int resultUnsignedRightShiftNegative = negativeNumber >>> 1;

        System.out.println("Resultados para número positivo: ");
        System.out.println("Right Shift: " + resultRightShiftPositive);
        System.out.println("Unsigned Right Shift: " + resultUnsignedRightShiftPositive);

        System.out.println("\nResultado para número negativo: ");
        System.out.println("Right Shift: " + resultRightShiftNegative);
        System.out.println("Unsigned Right Shift: " + resultUnsignedRightShiftNegative);
    }
}
