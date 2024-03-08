package lesson10;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        int randomInt = generateRandomInt(1, 50);
        System.out.println("Número aleatório: " + randomInt);
    }
    //função para gerar número aleatório entre min e max
    public static int generateRandomInt(int min, int max) {
        if (min > max || max <= 0) {
            throw new IllegalArgumentException("Intervalo inválido");
        }
        //math.random() gera um número entre 0 e 1
        //multiplicamos por max - min + 1 para abranger o intervalo desejado
        //add min p ajustar o início do intervalo
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
