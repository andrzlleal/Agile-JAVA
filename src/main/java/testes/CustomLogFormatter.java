package testes;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {
    private final CountingLogHandler countingHandler;

    public CustomLogFormatter(CountingLogHandler countingHandler) {
        this.countingHandler = countingHandler;
    }

    @Override
    public String format(LogRecord record) {
        StringBuilder formattedMessage = new StringBuilder();
        formattedMessage.append(record.getLevel()).append(": ").append(record.getMessage());

        if (countingHandler != null) {
            // Se o manipulador de contagem estiver presente, adicione a contagem para o nível atual.
            int count = countingHandler.getSeverityCount(record.getLevel());
            formattedMessage.append(" (").append(record.getLevel()).append(" total = ").append(count).append(")");
        }

        return formattedMessage.toString();
    }
}
