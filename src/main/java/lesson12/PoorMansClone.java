package lesson12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PoorMansClone {
    public static <T> T cloneObject(T source) {
        try{
            //Obtém a classe do objeto de origem
            Class<?> clazz = source.getClass();
            //Obtém o construtor padrão(sem argumentos) da classe de objeto de origem
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            //Torna o construtor acessível
            constructor.setAccessible(true);
            //Cria uma nova instância do objeto
            T newInstance = (T) constructor.newInstance();

            //Obtém todos os campos declarados da classe do objeto de origem
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                //Torna o campo acessível
                field.setAccessible(true);
                //Obtém o valor do campo do objeto de origem
                Object value = field.get(source);
                //Define o valor do campo no novo objeto
                field.set(newInstance, value);
            }
            return newInstance;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        //Exemplo de uso
        MyClass original = new MyClass(10, "Hello");
        MyClass cloned = cloneObject(original);

        //Imprime as instâncias original e clonada para veriricar se os valores foram copiados corretamente
        System.out.println("Original: " +original);
        System.out.println("Cloned: " +cloned);
    }
    //Classe de exemplo para ser clonada
    static class MyClass{
        private final int intValue;
        private final String stringValue;

        public MyClass(int intValue, String stringValue) {
            this.intValue = intValue;
            this.stringValue = stringValue;

        }
        @Override
        public String toString() {
            return "MyClass{ " +
                    "intValue= " + intValue +
                    ", stringValue=' " + stringValue + '\'' +
                    '}';
        }
    }
}
