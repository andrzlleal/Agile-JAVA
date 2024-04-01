package lesson11Tests;

import lesson11.MyFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyFileTest {
    private static final String FILENAME = "test.txt";

    private MyFile myFile;

    @BeforeEach
    void setUp() {
        //garante que o arquivo não existe antes de cada teste
        File file = new File(FILENAME);
        if (file.exists()) {
            file.delete();
        }
        myFile = new MyFile(FILENAME);
    }
    @Test
    public void testWriteFileFromListOfLines() {
        //Lista de linhas a serem escritas no arquivo
        List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");

        //Escreve conteúdo no arquivo
        myFile.writeFileFromListOfLines(lines);

        //Verifica se o conteúdo foi escrito corretamente
        assertEquals(lines, myFile.readFileAsListOfLines());
    }
    @Test
    public void testOverwriteFileFromListOfLines() {
        //Escreve conteúdo inicial no arquivo
        List<String> initialLines = Arrays.asList("Initial line 1", "Initial line 2");
        myFile.writeFileFromListOfLines(initialLines);

        //sobrescreve o arquivo com novo contúdo
        List<String> newLines = Arrays.asList("New line 1", "New line 2");
        myFile.overwriteFileFromListOfLines(newLines);

        //verfica se o conteúdo do arquivo foi sobrescrito corretamente
        assertEquals(newLines, myFile.readFileAsListOfLines());
    }

    @Test
    public void testReadNonExistentFile() {
        assertThrows(RuntimeException.class, () -> myFile.readFileAsString());
        assertThrows(RuntimeException.class, () -> myFile.readFileAsListOfLines());
    }

    @Test
    public void testWriteAndReadFile() {
        //Escreve conteúdo no arquivo
        String contentToWrite = "Hello, world!\nThis is a test.";
        myFile.writeFileFromString(contentToWrite);

        //Verifica se o conteúdo foi escrito corretamente
        assertEquals(contentToWrite, myFile.readFileAsString());
        List<String> expectedLines = Arrays.asList("Hello, world!", "This is a test.");
        assertEquals(expectedLines, myFile.readFileAsListOfLines());
    }

    @Test
    public void testWriteExistingFile() {
        //Escreve conteúdo inicial no arquivo
        String initialContent = "Initial content.";
        myFile.writeFileFromString(initialContent);

        //Tenta escrever novamente no arquivo
        assertThrows(RuntimeException.class, () -> myFile.writeFileFromString("New content"));
    }

    @Test
    public void testDeleteFile() {
        //Escreve conteúdo no arquivo
        String contentToWrite = "Hello, world!\nThis is a test.";
        myFile.writeFileFromString(contentToWrite);

        //Deleta o arquivo
        myFile.deleteFile();

        //Verifica se o arquivo foi deletado
        assertFalse(new File(FILENAME).exists());
    }

    @Test
    public void testOverwriteFile() {
        //Escrever conteúdo inicial no arquivo
        String initialContent = "Initial content.";
        myFile.writeFileFromString(initialContent);

        //Sobrescrever o arquivo com novo conteúdo
        String newContent = "New content";
        myFile.overwriteFileFromString(newContent);

        //Verificar se o conteúdo do arquivo foi sobrescrito corretamente
        assertEquals(newContent, myFile.readFileAsString());
    }
}