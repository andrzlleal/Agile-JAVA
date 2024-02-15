package testes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionLogger {

    private static final Logger LOGGER = Logger.getLogger(ExceptionLogger.class.getName());

    public static void logExceptionWithReversedStackTrace(Exception exception) {
        // Converte a pilha de chamadas para uma matriz de elementos da pilha.
        StackTraceElement[] stackTrace = exception.getStackTrace();

        // Inverte a ordem dos elementos na matriz da pilha.
        StackTraceElement[] reversedStackTrace = new StackTraceElement[stackTrace.length];
        for (int i = 0; i < stackTrace.length; i++) {
            reversedStackTrace[i] = stackTrace[stackTrace.length - i - 1];
        }

        // Cria uma nova exceção com a pilha de chamadas invertida.
        Exception reversedException = new Exception(exception.getMessage());
        reversedException.setStackTrace(reversedStackTrace);

        // Loga a exceção invertida.
        LOGGER.log(Level.SEVERE, "Exceção com pilha de chamadas invertida:", reversedException);
    }

    public static void main(String[] args) {
        try {
            // Alguma operação que pode lançar uma exceção.
            throw new RuntimeException("Opa, algo deu errado!");
        } catch (RuntimeException e) {
            // Loga a exceção com a pilha de chamadas invertida.
            logExceptionWithReversedStackTrace(e);
        }
    }
}