package Lesson13;

import java.util.HashMap;
import java.util.Map;

public class AlarmClock {

    //Mapa para armazenar eventos e horários dos alarmes
    private final Map<String, String> events = new HashMap<>();

    //Método para definir um alarme com um evento e horário específico
    public void setAlarm(String event, String alarmTime) {
        events.put(alarmTime, event);
    }
    //Método para obter o evento associado a um horário de alarme específico
    public String getEvent(String alarmTime) {
        return events.get(alarmTime);
    }
    //Método para verificar os alarmes com base no horário atual
    public void checkAlarms(String currentTime) {
        if (events.containsKey(currentTime)) {
            System.out.println("Alarm for " + events.get(currentTime) + "!");
        }
    }

}
