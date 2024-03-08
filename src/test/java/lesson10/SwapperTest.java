package lesson10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SwapperTest {
    public static void main(String[] args) {
        List<Integer> numberList = createNumberList();
        shuffleList(numberList, 100);

        testSwapper(numberList);
    }

    //Cria uma lista de números de 1 a 100
    private static List<Integer> createNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numberList.add(i);
        }
        return numberList;
    }

    //Troca aleatoriamente elementos da lista um número especificado de vezes
    private static void shuffleList(List<Integer> list, int swaps) {
        Random random = new Random();
        for (int i = 0; i < swaps; i++) {
            int index1 = random.nextInt(list.size());
            int index2 = random.nextInt(list.size());
            Collections.swap(list, index1, index2);
        }
    }

    //Testa se o tamanho da lista permanece o mesmo e se pelo menos dois números foram trocados
    private static void testSwapper(List<Integer> originalList) {
        List<Integer> newList = createNumberList();

        int differentNumbersCount = 0;

        for (int i = 0; i < originalList.size(); i++) {
            if (!originalList.get(i).equals(newList.get(i))) {
                differentNumbersCount++;
            }
        }

        //Verifica se o tamanho da lista permanece o mesmo
        if (originalList.size() == newList.size()) {
            System.out.println("O tamanho da lista permanece o mesmo.");
        } else {
            System.out.println("Erro: O tamanho da lista foi alterado.");
        }

        //Verifica se pelo menos dois números foram trocados
        if (differentNumbersCount >= 2) {
            System.out.println("Pelo menos dois números foram trocados corretamente.");
        } else {
            System.out.println("Erro: A troca não envolve pelo menos dois números.");
        }
    }
}