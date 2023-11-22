package org.example;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Map<String, String> novo_map = new HashMap<>();
        System.out.println(novo_map);
        System.out.println(novo_map.isEmpty());

        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        hash_map.put(0, "Estude");
        hash_map.put(1, "na");
        hash_map.put(2, "Trybe!");
        hash_map.put(3, "Be");
        hash_map.put(5, "Trybe");

        System.out.println("Elementos internos do map: " + hash_map);

        System.out.println("Verificar se a chave 0 existe " +
                hash_map.containsKey(0));

        System.out.println("Verificar se a chave 10 existe " +
                hash_map.containsKey(10));

        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(0, "Aprenda");
        map.put(1, "com");
        map.put(2, "a");
        map.put(3, "Trybe");


        System.out.println("Elementos internos do map: " + map);


        System.out.println("Verificar a chave 0: " + map.get(0));

        System.out.println("Verificar a chave 5: " + map.get(5));
    }
    }
