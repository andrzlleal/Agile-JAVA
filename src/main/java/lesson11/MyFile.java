package lesson11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFile {
    private final File file;

    //Construtor que recebe o nome do arquivo como argumento
    public MyFile(String filename) {
        this.file = new File(filename);
    }
    //Método para ler o conteúdo do arquivo como uma String
    public String readFileAsString() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            //Ler cada linha do arquivo e adiciona-la ao StringBuilder
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            //Lançar uma exceção se houver erro ao ler o arquivo
            throw new RuntimeException("Error reading file: " + file.getName(), e);
        }
        //Remover linhas em branco extras do final e retornar o conteúdo como String
        return content.toString().trim();
    }
    //Método para ler o conteúdo do arquivo como uma lista de linhas
    public List<String> readFileAsListOfLines() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            //Ler cada linha do arquivo e adicionar à lista
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            //Lançar uma exceção se houver um erro ao ler o arquivo
            throw new RuntimeException("Error reading file: " + file.getName(), e);
        }
        //Remover linhas em branco extras do final e retornar uma lista de linhas
        while (!lines.isEmpty() && lines.getLast().trim().isEmpty()) {
            lines.removeLast();
        }
        return lines;
    }
    //Método para escrever uma String no arquivo
    public void writeFileFromString(String content) {
        //Verificar se o arquivo já existe e lançar uma exceção se sim
        if (file.exists()) {
            throw new RuntimeException("File already exists: " + file.getName());
        }
        //Escrever o conteúdo no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + file.getName(), e);
        }
    }
    //Método para escrever uma lista de linhas no arquivo
    public void writeFileFromListOfLines(List<String> lines) {
        //Verificar se o arquivo já existe e lançar uma exceção
        if (file.exists()) {
            throw new RuntimeException("File already exists: " + file.getName());
        }
        //Escrever cada linha da lista no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + file.getName(), e);
        }
    }
    //Método para excluir o arquivo
    public void deleteFile() {
        //Verificar se o arquivo não existe e lnaçar uma exceção se não
        if (!file.exists()) {
            throw new RuntimeException("File not found: " + file.getName());
        }
        //Excluir o arquivo
        if (!file.delete()) {
            throw new RuntimeException("Error deleting file: " + file.getName());
        }
    }
    //Método para sobrescrever o conteúdo do arquivo com uma nova String
    public void overwriteFileFromString(String content) {
        //Escrever a nova String no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error overwriting file: " + file.getName(), e);
        }
    }
    //Método para sobrescrever o conteúdo do arquivo com uma lista de linhas
    public void overwriteFileFromListOfLines(List<String> lines) {
        //Escrever cada linha da lista no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error overwriting file: " + file.getName(), e);
        }
    }
}
