package lesson12;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyExample {
    //Interface que define o método toString
    interface StringRepresentable {
        String toString();
    }

    //Classe que representa o objeto alvo
    static class TargetObject implements StringRepresentable {
        @Override
        public String toString() {
            return "This is the original object's toString method";
        }

    }

    //Classe que representa o objeto dumper
    static class ObjectDumper {
        public String dump(Object object) {
            return "Dumping object: " + object.toString();
        }
    }

    //Classe do Proxy que delega para o objeto original ou para o objeto dumper
    static class MyProxy implements InvocationHandler {
        private final Object target;
        private final Object dumper;

        public MyProxy(Object target, Object dumper) {
            this.target = target;
            this.dumper = dumper;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //Se o método chamado for toString, delega para o objeto dumper
            if (method.getName().equals("toString")) {
                return method.invoke(dumper);
            }
            // Caso contrário, delega para o objeto original
            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) {
        //Criando uma instância do objeto alvo
        TargetObject targetObject = new TargetObject();

        //Criando uma instância do objeto dumper
        ObjectDumper objectDumper = new ObjectDumper();

        //Criando o Proxy
        StringRepresentable proxy = (StringRepresentable) Proxy.newProxyInstance(
                ProxyExample.class.getClassLoader(),
                new Class<?>[] { StringRepresentable.class },
                new MyProxy(targetObject, objectDumper)
        );

        //Chamando o método toString
        System.out.println(proxy.toString());
    }
}