import org.junit.Test;
import util.TestUtil;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IOUtilTest {
    static final String FILENAME1 = "IOUtilTest1.txt";
    static final String FILENAME2 = "IOUtilTest2.txt";

    @Test
    public void testDeleteSingleFile() throws IOException {
        create(FILENAME1);

        assertTrue(IOUtil.delete(FILENAME1));
        TestUtil.assertGone(FILENAME1);
    }
    @Test
    public void testDeleteMultipleFiles() throws IOException {
        create(FILENAME1, FILENAME2);
        assertTrue(IOUtil.delete(FILENAME1, FILENAME2));
        TestUtil.assertGone(FILENAME1, FILENAME2);
    }
    @Test
    public void testDeleteNoFile() throws IOException {
        TestUtil.delete(FILENAME1);
        assertFalse(IOUtil.delete(FILENAME1));
    }
    @Test
    public void testDeletePartiallySuccessful() throws IOException {
        create(FILENAME1);
        TestUtil.delete(FILENAME2);
        assertFalse(IOUtil.delete(FILENAME1, FILENAME2));
        TestUtil.assertGone(FILENAME1);
    }
    private void create(String... filenames) throws IOException {
        for (String filename: filenames) {
            TestUtil.delete(filename);
            new File(filename).createNewFile();
        }
    }
}
