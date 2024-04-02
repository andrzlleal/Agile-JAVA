package lesson11;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PrimitiveSizeCalculator {
    public static void main(String[] args) {
        System.out.println("Primitive Type Sizes (in bytes):");
        System.out.println("-----------------------------------");

        //Tamanhos dos tipos primitivos
        System.out.println("byte: " + getSize(new byte[1]));
        System.out.println("short: " + getSize((short) 0));
        System.out.println("int: " + getSize(0));
        System.out.println("long: " + getSize(0L));
        System.out.println("float: " + getSize(0.0f));
        System.out.println("double: " + getSize(0.0));
        System.out.println("char: " + getSize((char) 0));
        System.out.println("boolean: " + getSize(false));
    }

    //Método para calcular o tamanho de um tipo primitivo
    public static int getSize(Object obj) {
        try {
            //Cria um fluxo de saída de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);

            //Escreve o objeto no fluxo de dados
            if (obj instanceof Boolean) {
                dos.writeBoolean((Boolean) obj);
            } else if (obj instanceof Character) {
                dos.writeChar((Character) obj);
            } else if (obj instanceof Byte) {
                dos.writeByte((Byte) obj);
            } else if (obj instanceof Short) {
                dos.writeShort((Short) obj);
            } else if (obj instanceof Integer) {
                dos.writeInt((Integer) obj);
            } else if (obj instanceof Long) {
                dos.writeLong((Long) obj);
            } else if (obj instanceof Float) {
                dos.writeFloat((Float) obj);
            } else if (obj instanceof Double) {
                dos.writeDouble((Double) obj);
            }

            //Fecha o fluxo de dados
            dos.close();

            //Retorna o tamanho do fluxo de bytes
            return baos.size();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
