package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(0, "a");
        map.put(1, "b");
        map.put(2, "c");


        System.out.println("Elementos internos do map: " + map);

        System.out.println("Verificando a chave 0: " + map.get(0));

        System.out.println("Verificando a chave 5: " + map.get(5));
        
    }

}