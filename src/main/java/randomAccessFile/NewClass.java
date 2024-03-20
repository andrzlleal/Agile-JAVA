package randomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class NewClass {
    public static void main(String[] args)
    {
        try
        {
            double d = 1.5;
            float f = 14.56f;

            // Creating a new RandomAccessFile - "GEEK"
            RandomAccessFile geek = new RandomAccessFile("GEEK.txt", "rw");

            // Writing to file
            geek.writeUTF("Hello Geeks For Geeks");

            // File Pointer at index position - 0
            geek.seek(0);

            // read() method :
            System.out.println("Use of read() method : " + geek.read());

            geek.seek(0);

            byte[] b = {1, 2, 3};

            // Use of .read(byte[] b) method :
            System.out.println("Use of .read(byte[] b) : " + geek.read(b));

            // readBoolean() method :
            System.out.println("Use of readBoolean() : " + geek.readBoolean());

            // readByte() method :
            System.out.println("Use of readByte() : " + geek.readByte());

            geek.writeChar('c');
            geek.seek(0);

            // readChar() :
            System.out.println("Use of readChar() : " + geek.readChar());

            geek.seek(0);
            geek.writeDouble(d);
            geek.seek(0);

            // read double
            System.out.println("Use of readDouble() : " + geek.readDouble());

            geek.seek(0);
            geek.writeFloat(f);
            geek.seek(0);

            // readFloat() :
            System.out.println("Use of readFloat() : " + geek.readFloat());

            geek.seek(0);
            // Create array upto geek.length
            byte[] arr = new byte[(int) geek.length()];
            // readFully() :
            geek.readFully(arr);

            String str1 = new String(arr);
            System.out.println("Use of readFully() : " + str1);

            geek.seek(0);

            // readFully(byte[] b, int off, int len) :
            geek.readFully(arr, 0, 8);

            String str2 = new String(arr);
            System.out.println("Use of readFully(byte[] b, int off, int len) : " + str2);
        }
        catch (IOException ex)
        {
            System.out.println("Something went Wrong");
            ex.printStackTrace();
        }
    }
}
