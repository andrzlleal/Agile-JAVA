package lesson11;

import java.io.*;

public class PoorMansClone {
    private String[] args;

    //Método para clonar um objeto usando serialização e desserialização
    public static <T extends Serializable> T cloneObject(T object) {
        try {
            //Serializar o objeto para um fluxo de bytes
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(object);
            out.flush();

            //Desserializar o fluxo de bytes para criar uma cópia do objeto
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            @SuppressWarnings("unckecked")
                    T clonedObject = (T) in.readObject();

            return clonedObject;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Exemplo de uso
    public void main(String[] args) {
        this.args = args;
        //Objeto a ser clonado
        MyClass original = new MyClass(42, "Hello");

        //Clonar o objeto
        MyClass cloned = cloneObject(original);

        //Verificar se a clonagem foi bem-sucedida
        if (cloned != null) {
            System.out.println("Original: " + original);
            System.out.println("Cloned: " + cloned);
        }
    }
    //Classe exemplo para clonagem
    public static class MyClass implements Serializable {
        private final int number;
        private final String text;

        public MyClass(int number, String text) {
            this.number = number;
            this.text = text;
        }
        @Override
        public String toString() {
            return "MyClass{" +
                    "number=" + number +
                    ", text='" + text + '\'' +
                    '}';
        }
    }
}



