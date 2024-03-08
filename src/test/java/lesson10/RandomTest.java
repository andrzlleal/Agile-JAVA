package lesson10;

import java.util.Random;

public class RandomTest {
    public static void main (String[] args) {
        //Random com semente 1
        Random randomWithSeed = new Random(1);
        
        //random sem semente
        Random randomWithoutSeed = new Random();
        
        //Gerar e imprimir os próximos 5 números aleatórios para cada obj Random
        System.out.println("Random com semente 1: ");
            
            for (int i = 0; i < 5; i++) {
                System.out.println(randomWithSeed.nextDouble());
            }
        System.out.println("\n Random sem semente: ");
            for (int i = 0; i < 5; i++) {
                System.out.println(randomWithoutSeed.nextDouble());
            }
            
            //teste para provar a diferença
        testRandomEquality(randomWithoutSeed, randomWithoutSeed);
    }
    //Testa se as próximas sequências de números aleatórios são diferentes
    private static void testRandomEquality(Random random1, Random random2) {
        double value1 =  random1.nextDouble();
        double value2 = random2.nextDouble();

        if (value1 != value2) {
            System.out.println("\n Os próximos números aleatórios são diferentes. ");
        } else {
            System.out.println("\n Erro: Os próximos números aleatórios são iguais. ");
        }
    }

}
