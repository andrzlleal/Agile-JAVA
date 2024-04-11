package util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LineWriterTest {
    @Test
    public void testMultipleRecords() throws IOException {
        final String file = "LineWriterTest.testCreate.txt";
        try {
            LineWriter.write(file, new String[] {"a", "b"});
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                assertEquals("a", reader.readLine());
                assertEquals("b", reader.readLine());
                assertNull(reader.readLine());
            }
            finally {
                if (reader != null)
                    reader.close();
            }
        }
        finally {
            TestUtil.delete(file);
        }
    }
}
