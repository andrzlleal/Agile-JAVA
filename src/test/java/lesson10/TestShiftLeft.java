package lesson10;

public class TestShiftLeft {
    public static void main(String[] args) {
        int original = 17;

        //usando o operador << para converter 17 em 34
        int result = original << 1;

        System.out.println("Original number: " + original);
        System.out.println("Result after shift left: " + result);

        //verificando se o resultado é igual a 34
        if (result == 34) {
            System.out.println("The result is correct!");
        } else {
            System.out.println("The result is not correct");
        }
    }
}
