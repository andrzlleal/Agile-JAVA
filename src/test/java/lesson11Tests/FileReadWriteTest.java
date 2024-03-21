package lesson11Tests;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadWriteTest {
    private static final String TEXT = "Create a test to write the text of this exercise to the file system.";

    @Test
    public void testWriteAndReadFile() throws IOException {
        // Escrever o texto em um arquivo
        Path filePath = Path.of("test.txt");
        Files.writeString(filePath, TEXT);

        // Ler o arquivo e verificar se o conteúdo está correto
        String content = Files.readString(filePath);
        Assertions.assertEquals(TEXT, content);
    }

    @AfterEach
    public void cleanup() throws IOException {
        // Excluir o arquivo após cada teste
        Files.deleteIfExists(Path.of("test.txt"));
    }
}

