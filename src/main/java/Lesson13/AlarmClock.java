package Lesson13;

import java.util.HashMap;
import java.util.Map;

public class AlarmClock {
    private final Map<String, String> events = new HashMap<>();
    private final Object lock = new Object();

    //Define um alarme com um evento e horário específico
    public void setAlarm(String event, String alarmTime) {
        events.put(alarmTime, event);
        System.out.println("Alarme definido para " + event + " às " + alarmTime);
    }
    //Cancela um alarme pelo nome do evento
    public void cancelAlarm(String event) {
        synchronized (lock) {
            events.values().removeIf(value -> value.equals(event));
            System.out.println("Alarme para " + event + " cancelado");
        }
    }
    //Obtém o evento associado a um horário de alarme específico
    public String getEvent(String alarmTime) {
        return events.get(alarmTime);
    }
    //Verifica os alarmes com base no horário atual
    public void checkAlarms(String currentTime) {
        if (events.containsKey(currentTime)) {
            System.out.println("Alarm for " + events.get(currentTime) + "!");
        } else {
            System.out.println("Nenhum alarme para o horário atual: " + currentTime);
        }
    }
    //Aguarda até ser notificado para verificar os alarmes
    public void waitForAlarm() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Thread esperando...");
            lock.wait();
            System.out.println("Thread acordou!");
        }
    }
    //Notifica o thread para continuar
    public void notifyAlarm() {
        synchronized (lock) {
            System.out.println("Notificando thread...");
            lock.notify();
        }
    }
}