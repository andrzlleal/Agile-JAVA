package lesson11Tests;

import lesson11.Dir;
import lesson11.MyFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DirTest {
    private static final String TEST_DIRECTORY = "testDir";
    private static final String TEST_FILE_1 = TEST_DIRECTORY + "/testFile1.txt";
    private static final String TEST_FILE_2 = TEST_DIRECTORY + "/testFile2.txt";

    private Dir dir;

    @BeforeEach
    void setUp() {
        //Cria um diretório de teste antes de cada teste
        try {
            Files.createDirectories(new File(TEST_DIRECTORY).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        dir = new Dir(TEST_DIRECTORY);
    }

    @Test
    void ensureExists_directoryDoesNotExist_createsDirectory() {
        //Exclui o diretório antes de chamar ensureExists
        assertTrue(deleteDirectory(new File(TEST_DIRECTORY)));

        //Chama o método ensureExists
        dir.ensureExists();

        //Verifica se o diretório foi criado
        assertTrue(new File(TEST_DIRECTORY).exists());
    }

    @Test
    void ensureExists_directoryAlreadyExists_doesNotCreateDirectory() {
        //Chama o método ensureExists
        dir.ensureExists();

        //Verifica se o diretório existe
        assertTrue(new File(TEST_DIRECTORY).exists());

        //Chama o método ensureExists novamente
        dir.ensureExists();

        //Verifica se o diretório ainda existe (não deve ter sido criado novamente)
        assertTrue(new File(TEST_DIRECTORY).exists());
    }

    @Test
    void listFiles_directoryHasFiles_returnsListOfFiles() {
        //Cria um diretório de teste
        String testDirPath = "testDir";
        File testDir = new File(testDirPath);
        testDir.mkdir();

        //Cria arquivos de teste dentro do diretório
        String testFilePath1 = testDirPath + File.separator + "testFile1.txt";
        String testFilePath2 = testDirPath + File.separator + "testFile2.txt";
        File testFile1 = new File(testFilePath1);
        File testFile2 = new File(testFilePath2);
        try {
            assertTrue(testFile1.createNewFile());
            assertTrue(testFile2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Cria um objeto Dir para o diretório de teste
        Dir dir = new Dir(testDirPath);

        //Obtém a lista de arquivos usando o método listFiles
        List<MyFile> files = dir.listFiles();

        //Verifica se a lista contém os arquivos criados
        assertTrue(files.stream().anyMatch(file -> file.getName().equals(testFile1.getName())));
        assertTrue(files.stream().anyMatch(file -> file.getName().equals(testFile2.getName())));

        //Deleta os arquivos de teste e o diretório de teste após o teste
        testFile1.delete();
        testFile2.delete();
        testDir.delete();
    }
    @Test
    void listFiles_directoryNotCreated_throwsException() {
        //Exclui o diretório antes de chamar listFiles
        assertTrue(deleteDirectory(new File(TEST_DIRECTORY)));

        //Verifica se o diretório não existe
        assertFalse(new File(TEST_DIRECTORY).exists());

        //Tentar criar uma instância de Dir com o diretório inexistente e verificar se lança a exceção correta
        try {
            Dir dir = new Dir(TEST_DIRECTORY);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            //Verifica se a mensagem de exceção está correta
            assertEquals("Directory does not exist: testDir", e.getMessage());
        }
    }

    //Método auxiliar para excluir recursivamente um diretório
    private boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}