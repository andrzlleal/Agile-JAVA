package testes;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountingDiscardHandlerTest {

    public static void main(String[] args) {
        // Criar uma instância do manipulador
        CountingDiscardHandler countingHandler = new CountingDiscardHandler();

        // Simular mensagens de log em vários níveis de gravidade
        simulateLogMessages(countingHandler);

        // Obter e imprimir a contagem por gravidade
        Map<Level, Integer> severityCountMap = countingHandler.getSeverityCountMap();
        for (Map.Entry<Level, Integer> entry : severityCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void simulateLogMessages(CountingDiscardHandler handler) {
        // Configurar o manipulador no logger
        Logger logger = Logger.getLogger("ExampleLogger");
        logger.addHandler(handler);

        // Simular mensagens de log em vários níveis de gravidade
        for (int i = 0; i < 5; i++) {
            logger.severe("Mensagem de erro");
            logger.warning("Aviso");
            logger.info("Informação");
            logger.config("Configuração");
        }

        // Remover o manipulador para evitar logs indesejados
        logger.removeHandler(handler);
    }
}