package testes;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class CountingLogHandler extends Handler {
    private final Map<Level, Integer> severityCountMap;
    private final CustomLogFormatter formatter;
    private final StringBuilder logSummary;


    public CountingLogHandler() {
        severityCountMap = new HashMap<>();
        formatter = new CustomLogFormatter(this);
        logSummary = new StringBuilder();


        // Inicializa o mapa com contagens zeradas para cada nível de gravidade.
        for (Level level : new Level[]{Level.ALL, Level.CONFIG, Level.FINE, Level.FINER, Level.FINEST,
                Level.INFO, Level.OFF, Level.SEVERE, Level.WARNING}) {
            severityCountMap.put(level, 0);
        }
    }
    @Override
    public void publish(LogRecord record) {
        // Atualiza a contagem para o nível de gravidade desta mensagem.
        Level level = record.getLevel();
        severityCountMap.put(level, severityCountMap.get(level) + 1);

        // Formata a mensagem usando o formatador personalizado.
        String formattedMessage = formatter.format(record);

        // Armazena a mensagem formatada no logSummary.
        logSummary.append(formattedMessage).append("\n");
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }

    public int getSeverityCount(Level level) {
        return severityCountMap.get(level);
    }

    public String getLogSummary() {
        return logSummary.toString();
    }

    public static void main(String[] args) {
        CountingLogHandler countingHandler = new CountingLogHandler();
        countingHandler.setFormatter(new CustomLogFormatter(countingHandler));

        // Adiciona o manipulador ao logger apropriado.

        // Simula mensagens de log em vários níveis de gravidade.
        Logger logger = Logger.getLogger("ExampleLogger");
        logger.addHandler(countingHandler);

        for (int i = 0; i < 5; i++) {
            logger.severe("Mensagem de erro");
            logger.warning("Aviso");
            logger.info("Informação");
            logger.config("Configuração");
        }

        // Obtém e imprime a contagem por gravidade.
        for (Level level : new Level[]{Level.ALL, Level.CONFIG, Level.FINE, Level.FINER, Level.FINEST,
                Level.INFO, Level.OFF, Level.SEVERE, Level.WARNING}) {
            System.out.println(level + " total = " + countingHandler.getSeverityCount(level));
        }

        // Obtém e imprime o resumo do log.
        System.out.println("Log Summary:\n" + countingHandler.getLogSummary());

        // Remover o manipulador para evitar logs indesejados.
        logger.removeHandler(countingHandler);
    }
}

