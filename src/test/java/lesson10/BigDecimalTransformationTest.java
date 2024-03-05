package lesson10;

import java.math.BigDecimal;

public class BigDecimalTransformationTest {
    public static void main(String[] args) {
        //criação de dois BigDecimal
        BigDecimal firstValue = new BigDecimal("10.00");
        BigDecimal secondValue = new BigDecimal("1");

        //verificação inicial de que eles não são iguais
        if (!firstValue.equals(secondValue)) {
            System.out.println("Os valores iniciais não são iguais.");
        }
        //multiplicação e ajuste da escala para tornar os valores iguais
        secondValue = secondValue.multiply(new BigDecimal("10").setScale(2, BigDecimal.ROUND_HALF_UP));

        //verificação de que agora os valores são iguais
        if (firstValue.equals(secondValue)) {
            System.out.println("Após a transformação, os valores são iguais.");
        }
        //reversão da transformação para obter de volta o valor original
        BigDecimal reversedValue = firstValue.divide(new BigDecimal("10")).setScale(0, BigDecimal.ROUND_HALF_UP);

        //verificação de que o valor revertido é igual ao valor original
        if (reversedValue.equals(new BigDecimal("1"))) {
            System.out.println("A reversão foi bem-sucedida. Voltamos ao valor original");
        }
    }
}
