package lesson11Tests;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;

public class ExceptionStackTraceCaptureTest {
    @Test
    public void testExceptionStackTraceCaptureWithOutputStreamWriterAndChar() {
        try {
            //Lança uma exceção para capturar a stack trace
            throwException();
        } catch (IOException e) {
            //Captura a stack trace da exceção em uma string usando OutputStreamWriter com StringWriter
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            printWriter.flush();
            String stackTrace = stringWriter.toString();

            //Verifica se a stack trace contém o nome da exceção
            assertTrue(stackTrace.contains("java.io.IOException"));
        }
    }
    @Test
    public void testExceptionStackTraceCaptureWithOutputStreamAndByte() {
        try {
            //Lança uma exceção para capturar a stack trace
            throwException();
        } catch (Exception e) { //Captura qualquer exceção genérica
            //Captura a stack trace da exceção em uma string usando StringWriter e PrintWriter
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));

            //Adiciona instruções de depuração para visualizar a stack trace capturada
            System.out.println("Captured stack trace:");
            System.out.println(stringWriter.toString());

            //Verifica se a stack trace contém o nome da classe da exceção
            assertTrue(stringWriter.toString().contains(e.getClass().getName()));
        }
    }

    private void throwException() throws IOException {
        throw new IOException("Exemplo de exceção para capturar a stack trace");
    }
}