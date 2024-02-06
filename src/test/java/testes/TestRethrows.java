package testes;

import org.junit.Test;

public class TestRethrows {

    @Test(expected = SimpleException.class)
    public void testRethrows() {
        rethrows();
    }

    private void rethrows() {
        try {
            blowsUp();
        } catch (RuntimeException originalException) {
            // Captura a exceção lançada por blowsUp
            // Cria uma nova SimpleException, encadeando a exceção original como causa
            throw new SimpleException("Exceção recriada", originalException);
        }
    }

    private void blowsUp() {
        throw new SimpleException("Somebody should catch this!");
    }

    // Nova exceção que estende RuntimeException
    static class SimpleException extends RuntimeException {
        public SimpleException(String message) {
            super(message);
        }

        public SimpleException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
