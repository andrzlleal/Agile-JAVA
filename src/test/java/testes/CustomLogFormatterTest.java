package testes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomLogFormatterTest {

    @Test
    public void testWithoutCountingLogHandler() {

        Logger logger = Logger.getLogger("Logger");

        // Remova manipuladores existentes para evitar interferências.
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }

        CustomLogFormatter formatter = new CustomLogFormatter(null);
        CountingLogHandler countingHandler = new CountingLogHandler();
        countingHandler.setFormatter(formatter);

        // Adiciona o manipulador ao logger apropriado.
        logger.addHandler(countingHandler);

        // Define um nível de log em vários niveis de gravidades
        logger.setLevel(Level.ALL);

        // Logs de depuração para verificar o estado do logger.
        System.out.println("Handlers do logger: " + Arrays.toString(logger.getHandlers()));
        System.out.println("Nivel do Logger: " + logger.getLevel());

        // Simula mensagens de log em vários níveis de gravidade.
        for (int i = 0; i < 5; i++) {
            logger.severe("Mensagem de erro");
            logger.warning("Aviso");
            logger.info("Informação");
            logger.config("Configuração");
        }

        // Obtém e verifica a contagem por gravidade.
        assertEquals(5, countingHandler.getSeverityCount(Level.SEVERE));
        assertEquals(5, countingHandler.getSeverityCount(Level.WARNING));
        assertEquals(5, countingHandler.getSeverityCount(Level.INFO));
        assertEquals(5, countingHandler.getSeverityCount(Level.CONFIG));

        // Remove o manipulador para evitar logs indesejados.
        logger.removeHandler(countingHandler);
    }
    @Test
    public void testWithCountingLogHandler() {
        Logger logger = Logger.getLogger("ExampleLogger");
        CountingLogHandler countingHandler = new CountingLogHandler();
        countingHandler.setFormatter(new CustomLogFormatter(countingHandler));

        // Adiciona o manipulador ao logger apropriado.
        logger.addHandler(countingHandler);

        // Define um nível de log em vários niveis de gravidades
        logger.setLevel(Level.ALL);

        // Mensagens de log em vários níveis de gravidade.
        for (int i = 0; i < 5; i++) {
            logger.severe("Mensagem de erro");
            logger.warning("Aviso");
            logger.info("Informação");
            logger.config("Configuração");
        }

        // Obtém e verifica a contagem por gravidade.
        assertEquals(5, countingHandler.getSeverityCount(Level.SEVERE));
        assertEquals(5, countingHandler.getSeverityCount(Level.WARNING));
        assertEquals(5, countingHandler.getSeverityCount(Level.INFO));
        assertEquals(5, countingHandler.getSeverityCount(Level.CONFIG));

        // Obtém e verifica o resumo do log.
        String logSummary = countingHandler.getLogSummary();
        System.out.println("Log Summary:\n" + logSummary);


        // Remove o manipulador para evitar logs indesejados.
        logger.removeHandler(countingHandler);
    }
}