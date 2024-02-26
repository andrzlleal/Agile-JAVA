package exerciseName;

import java.util.HashSet;
import java.util.Set;

public class ModifiedNameSetTest {
    public static void main(String[] args) {
        //criando instâncias da classe Name
        Name foo = new Name("Foo");
        Name bar = new Name("Bar");
        Name baz = new Name("Baz");

        //Criando um conjunto (Set) de Name
        Set<Name> nameSet = new HashSet<>();
        nameSet.add(bar);
        nameSet.add(baz);

        //testando se o conjunto contém exatamente a instância Name("Foo")
        boolean containsFoo = nameSet.stream().anyMatch(name -> name.equals(new Name("Foo")));

        //Imprimindo o resultado do teste
        System.out.println("O conjunto contém exatamente Name(\"Foo\"): " + containsFoo);
    }
}
