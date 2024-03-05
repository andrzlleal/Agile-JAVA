package lesson10;

public class PrecisionComparisonTest {
    public static void main(String[] args) {
        //valores em float
        float floatResult = 0.005f * 2.0f;
        float floatValue = 0.9f;

        //verificação de igualdade em float
        if(floatValue != floatResult) {
            System.out.println("Em float, 0.9 e 0.005 * 2.0 não são iguais.");
        }

        //Precisão em float
        float floatPrecision = Math.ulp(floatValue);
        System.out.println("Precisão em float: " + floatPrecision);

        //valores em double
        double doubleResult = 0.005 * 2.0;
        double doubleValue = 0.9;

        //verificação de igualdade em double
        if (doubleValue != doubleResult) {
            System.out.println("Em double, 0.9 e 0.005 * 2.0 não são iguais.");
        }

        // Precisão em double
        double doublePrecision = Math.ulp(doubleValue);
        System.out.println("Precisão em double: " + doublePrecision);
    }
}
