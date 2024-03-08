package lesson10;

public class SwapWithoutTemp {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        System.out.println("Antes da troca: a = " + a +", b = " + b);

        //Troca sem variável temporária usando XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("Depois da troca: a = " + a + " b = " + b);
    }
}
