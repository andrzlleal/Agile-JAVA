package testes;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CountingDiscardHandler extends Handler {

    private final Map<Level, Integer> severityCountMap;

    public CountingDiscardHandler() {
        severityCountMap = new HashMap<>();
        // Inicializa o mapa com contagens zeradas para cada nível de gravidade.
        severityCountMap.put(Level.ALL, 0);
        severityCountMap.put(Level.CONFIG, 0);
        severityCountMap.put(Level.FINE, 0);
        severityCountMap.put(Level.FINER, 0);
        severityCountMap.put(Level.FINEST, 0);
        severityCountMap.put(Level.INFO, 0);
        severityCountMap.put(Level.OFF, 0);
        severityCountMap.put(Level.SEVERE, 0);
        severityCountMap.put(Level.WARNING, 0);
    }

    @Override
    public void publish(LogRecord record) {
        // Descarta a mensagem.

        // Incrementa a contagem para o nível de gravidade desta mensagem.
        Level level = record.getLevel();
        severityCountMap.put(level, severityCountMap.get(level) + 1);
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }

    public Map<Level, Integer> getSeverityCountMap() {
        return new HashMap<>(severityCountMap);
    }

    public static void main(String[] args) {
        CountingDiscardHandler countingHandler = new CountingDiscardHandler();
        // Adiciona o manipulador ao logger apropriado.

        // Simula mensagens de log em vários níveis de gravidade.
        for (int i = 0; i < 5; i++) {
            countingHandler.publish(new LogRecord(Level.SEVERE, "Mensagem de erro"));
            countingHandler.publish(new LogRecord(Level.WARNING, "Aviso"));
            countingHandler.publish(new LogRecord(Level.INFO, "Informação"));
            countingHandler.publish(new LogRecord(Level.CONFIG, "Configuração"));
        }

        // Obtém e imprime a contagem por gravidade.
        Map<Level, Integer> severityCountMap = countingHandler.getSeverityCountMap();
        for (Map.Entry<Level, Integer> entry : severityCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}