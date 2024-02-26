package exerciseName;

public class Name {
    private String value;

    //construtor que recebe o valor do nome
    public Name(String value) {
        this.value = value;
    }
    //método equals para comparar instâncias de Name
    @Override
    public boolean equals(Object obj) {
        //verifica se é a mesma referência de objeto
        if (this == obj) {
            return true;
        }
        //verifica se o objeto é do tipo Name
        if (obj instanceof Name) {
            //Faz a comparação de strings ignorando casos
            Name otherName = (Name) obj;
            return this.value.equalsIgnoreCase(otherName.value);
        }
        //Se não for do tipo Name, considera como não igual
        return false;
    }
}
