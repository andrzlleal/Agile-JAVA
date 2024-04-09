package lesson12;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class ObjectDumper {
    //HashSet para manter o controle de objetos já processados para evitar loops infinitos
    private final Set<String> processedObjects = new HashSet<>();

    //Método público para iniciar a operação dumping do objeto
    public void dump(Object object) {
        dump(object, 0);
    }

    //Método privado para realizar o dumping do objeto com uma profundidade específica
    private void dump(Object object, int depth) {
        //Se o objeto é nulo, ou se já foi processado, ou se é uma classe do pacote java, retorna sem fazer nada
        if (object == null || processedObjects.contains(object.toString()) || object.getClass().getName().startsWith("java.")) {
            return;
        }
        //Adicionando o objeto à lista de objetos processados
        processedObjects.add(object.toString());

        //Obtém a classe do objeto
        Class<?> clazz = object.getClass();
        //Obtém todos os campos declarados da classe
        Field[] fields = clazz.getDeclaredFields();

        //Itera sobre os campos
        for (Field field : fields) {
            //Torna o campo acessível
            field.setAccessible(true);
            try {
                //Obtém o valor do campo no objeto
                Object value = field.get(object);
                //Constrói a string de indentação baseada na profundidade
                StringBuilder indent = new StringBuilder();
                for (int i = 0; i < depth; i++) {
                    indent.append("    ");
                }
                //Impressão do nome do campo, seu tipo primitivo (ou não) e seu valor
                System.out.println(indent.toString() + field.getName() + " (" + (field.getType().isPrimitive() ? "primitive" : field.getType().getName()) + ")"
                        + (java.lang.reflect.Modifier.isStatic(field.getModifiers()) ? " (static)" : "") + ": " + value);
                //Se o tipo do campo não for primitivo, chama recursivamente o método dump
                if (!field.getType().isPrimitive()) {
                    dump(value, depth + 1);
                }
            } catch (IllegalAccessException e) {
                //Em caso de exceção de acesso ilegal, imprime o stack trace
                e.printStackTrace();
            }
        }
    }
    //Método main para exemplo de uso
    public static void main(String[] args) {
        //Exemplo de uso do ObjectDumper
        ObjectDumper dumper = new ObjectDumper();
        dumper.dump(new MyClass());
    }
}
//Classe de exemplo com diversos tipos de campos
class MyClass {
    private final int privateIntField = 10;
    public String publicStringField = "Hello";
    private static final double privateStaticDoubleField = 3.14;
    public static boolean publicStaticBooleanField = true;
    private final InnerClass innerObject = new InnerClass();

    //Classe interna de exemplo
    private static class InnerClass {
        public String innerStringField = "Inner Hello";
    }
}
