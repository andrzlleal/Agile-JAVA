package lesson11;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dir {
    private final File directory;

    //Construtor que recebe o caminho do diretório como argumento
    public Dir(String directoryPath) {
        this.directory = new File(directoryPath);

        //Verificar se o caminho representa um diretório existente
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
        //Verificar se o diretório já existe
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
        //Verificar se o diretório foi criado
        if (!directory.exists()) {
            //Se não foi criado, lançar uma exceção
            throw new IllegalArgumentException("Directory has not been created yet: " + directory.getPath());
        }
        //Inicializar uma lista para armazenar os objetos Myfile
        List<MyFile> files = new ArrayList<>();

        //Iterar sobre os arquivos no diretório
        File[] fileList = directory.listFiles();
        if (fileList != null) {
            for (File file : fileList) {
                //Criar um objeto MyFile para cada arquivo e adicioná-lo à lista
                files.add(new MyFile(file.getPath()));
            }
        }
        //Retornar a lista de arquivos
        return files;
    }
}
