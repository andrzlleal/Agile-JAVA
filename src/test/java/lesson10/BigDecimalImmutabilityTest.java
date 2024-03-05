package lesson10;

import java.math.BigDecimal;

public class BigDecimalImmutabilityTest {
    public static void main(String[] args) {
        //criação de dois BigDecimal
        BigDecimal originalValue = new BigDecimal("10.50");

        BigDecimal secondValue = new BigDecimal("5.75");

        //add do segundo valor ao primeiro
        BigDecimal result = originalValue.add(secondValue);

        //impressão dos valores originais e do resultado da adição
        System.out.println("Valor original: " + originalValue);
        System.out.println("Resultado da adição: " + result);

        //verifica se o valor iterado permanece inalterado
        if (originalValue.equals(new BigDecimal("10.50"))) {
            System.out.println("O valor original permanece o mesmo. A imutabilidade foi demonstrada com sucesso.");
        } else {
            System.out.println("Algo deu errado, o valor original foi modificado.");
        }
    }
}
