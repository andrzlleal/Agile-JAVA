package lesson11Tests;

import lesson11.MyFile;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyFileTest {
    @Test
    public void testReadWriteFile() {
        // Criar instância de MyFile para o teste
        MyFile myFile = new MyFile("test.txt");

        //Escrever conteúdo no arquivo
        String contentToWrite = "Hello, world!\nThis is a test.";
        myFile.writeFileFromString(contentToWrite);

        // Ler conteúdo do arquivo como String e verificar se está correto
        String readContentAsString = myFile.readFileAsString();
        assertEquals(contentToWrite.trim(), readContentAsString.trim());

        // Ler conteúdo do arquivo como Lista de linhas e verificar se está correto
        List<String> readContentAsListOfLines = myFile.readFileAsListOfLines();
        List<String> expectedLines = Arrays.asList("Hello, world!", "This is a test.");
        assertEquals(expectedLines, readContentAsListOfLines);

    }
}

