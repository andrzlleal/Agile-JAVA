package lesson11Tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterPerformanceTest {
    public static void main(String[] args) {
        int dataSize = 1000; //Tamanho inicial dos dados

        long basicWriterTime, bufferedWriterTime;

        //Loop até alcançar uma melhoria de desempenho de 5x
        do {
            basicWriterTime = testBasicWriter(dataSize);
            bufferedWriterTime = testBufferedWriter(dataSize);

            System.out.println("Data size: " + dataSize);
            System.out.println("BasicWriter time: " + basicWriterTime + " ms");
            System.out.println("BufferedWriter time: " + bufferedWriterTime + " ms");
            dataSize *= 10; //Incrementa o tamanho dos dados para a próxima iteração

        } while (basicWriterTime / bufferedWriterTime < 5);
        System.out.println("Threshold reached at data size: " + dataSize);
    }
    //Método para testar o desempenho de escrita com BasicWriter
    private static long testBasicWriter(int dataSize) {
        long startTime = System.currentTimeMillis();

        try (FileWriter fileWriter = new FileWriter("basic_test.txt")) {
            for (int i = 0; i < dataSize; i++) {
                fileWriter.write('a'); //Escreve um caractere por vez
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }
    //Método para testar o desempenho de escrita com BufferedWriter
    private static long testBufferedWriter(int dataSize) {
        long startTime = System.currentTimeMillis();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("buffered_test.txt"))) {
            for (int i = 0; i < dataSize; i++) {
                bufferedWriter.write('a'); //Escreve um caractere por vez
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }
}
