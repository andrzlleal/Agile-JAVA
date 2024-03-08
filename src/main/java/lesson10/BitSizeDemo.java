package lesson10;

public class BitSizeDemo {
    public static void main(String[] args) {
        System.out.println("número de bits necessários para cada tipo integral: ");
        System.out.println("char: " + bitSize(char.class));
        System.out.println("byte: " + bitSize(byte.class));
        System.out.println("short: " + bitSize(short.class));
        System.out.println("int: " + bitSize(int.class));
        System.out.println("long: " + bitSize(long.class));
    }

    //Método para calcular o número de bits necessários para um tipo integral
    private static int bitSize(Class<?> type) {
        int bits = 8 * getTypeSize(type); // Cada byte contém 8 bits
        return type.isPrimitive() && !type.equals(char.class) ? bits + 1 : bits;
    }

    //Método para obter o tamanho do tipo em bytes
    private static int getTypeSize(Class<?> type) {
        if (type.equals(char.class) || type.equals(byte.class)) {
            return 1;
        } else if (type.equals(short.class)) {
            return 2;
        } else if (type.equals(int.class) || type.equals(float.class)) {
            return 4;
        } else if (type.equals(long.class) || type.equals(double.class)) {
            return 8;
        } else {
            throw new IllegalArgumentException("Tipo não suportado: " + type);
        }
    }
}


