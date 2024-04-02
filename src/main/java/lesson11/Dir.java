package lesson11;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dir {
    private boolean isReadOnly;
    private boolean isHidden;

    private final File directory;

    //Construtor que recebe o caminho do diretório como argumento
    public Dir(String directoryPath) {
        this.directory = new File(directoryPath);

        //Verifica se o caminho representa um diretório existente
        if (!directory.isDirectory()) {
            //Se não for um diretório, lançar uma exceção
            throw new IllegalArgumentException("Directory does not exist: " + directoryPath);
        }
        //Verificar se o caminho representa um arquivo
        if (directory.isFile()) {
            //Se for um arquivo, lançar uma exceção
            throw new IllegalArgumentException("Path is a file, not a directory: " + directoryPath);
        }
    }
    //Método para garantir que o diretório exista
    public void ensureExists() {
        //Verifica se o diretório já existe
        if (!directory.exists()) {
            //Se não existir, tentar criar o diretório
            boolean created = directory.mkdirs();
            if (!created) {
                //Se a criação falhar, lançar uma exceção
                throw new RuntimeException("Failed to create directory: " + directory.getPath());
            }
        }
    }
    //Método para retornar uma lista de objetos MyFile representando os arquivos no diretório
    public List<MyFile> listFiles() {
        //Verifica se o diretório foi criado
        if (!directory.exists()) {
            //Se não foi criado, lançar uma exceção
            throw new IllegalArgumentException("Directory has not been created yet: " + directory.getPath());
        }
        //Inicializa uma lista para armazenar os objetos Myfile
        List<MyFile> files = new ArrayList<>();

        //Itera sobre os arquivos no diretório
        File[] fileList = directory.listFiles();
        if (fileList != null) {
            for (File file : fileList) {
                //Criar um objeto MyFile para cada arquivo e adicioná-lo à lista
                files.add(new MyFile(file.getPath()));
            }
        }
        //Retorna a lista de arquivos
        return files;
    }
    //Classe interna de instância para encapsular atributos de diretório
    public static class Attributes {
        //Classe aninhada estática para encapsular atributos de diretório
            private final boolean isReadOnly;
            private final boolean isHidden;

            //Construtor da classe Attributes
            public Attributes(boolean isReadOnly, boolean isHidden) {
                this.isReadOnly = isReadOnly;
                this.isHidden = isHidden;
            }
            //Métodos para acessar os atributos encapsulados
            public boolean isReadOnly() {
                return isReadOnly;
            }
            public boolean isHidden() {
                return isHidden;
            }
        }
        //Método para obter os atributos de um diretório
        public Attributes getAttributes() {
            boolean readOnly = true; //Exemplo: atributo somente leitura definido como verdadeiro
            boolean hidden = false; //Exemplo: atributo oculto definido como falso
            return new Attributes(readOnly, hidden);
        }
}

