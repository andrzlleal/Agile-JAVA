package exerciseName;

import java.util.HashSet;
import java.util.Set;

public class NameTest {
    public static void main(String[] args) {
        //criação de instâncias da classe Name
        Name foo = new Name ("Foo");
        Name bar = new Name ("Bar");
        Name baz = new Name ("Baz");

        //Criando um conjunto de Set de Name

        Set<Name> nameSet =  new HashSet<>();

        nameSet.add(bar);
        nameSet.add(baz);

        //Testando se o conjunto contém a instância Name ("Foo")
        System.out.println("O conjunto contém Name(\"Foo\"): " + nameSet.contains(new Name("Foo")));

        //add a instância foo ao conjunto
        nameSet.add(foo);

        //testando novamente se o conjunto contém a instância Name("Foo")
        System.out.println("O conjunto agora contém foo: " + nameSet.contains(foo));


    }

}

