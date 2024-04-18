package lesson13Test;

import Lesson13.AlarmClock;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestAlarmClock {

    @Test
    public void testSetAlarm() {
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.setAlarm("Reunião", "09:00");

        assertEquals("Reunião", alarmClock.getEvent("09:00"));
    }

    @Test
    public void testCheckAlarms() throws InterruptedException {
        AlarmClock alarmClock = new AlarmClock();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Define um alarme para 10:00
        alarmClock.setAlarm("Reunião", "10:00");

        //Inicia um novo thread para verificar os alarmes
        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread iniciada.");
                //Aguarda até ser notificado
                alarmClock.waitForAlarm();
                //Verifica os alarmes após ser notificado
                alarmClock.checkAlarms("10:00");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();

        //Espera um pouco para garantir que o thread entre no estado de espera
        Thread.sleep(500);

        //Notifica o thread para continuar
        synchronized (alarmClock) {
            alarmClock.notifyAlarm();
        }

        //Espera um pouco para que o thread tenha tempo de acordar e verificar os alarmes
        Thread.sleep(2000);
        //Verifica se a mensagem de alarme foi impressa
        assertTrue(outputStream.toString().contains("Alarm for Reunião"));
    }
    @Test
    public void testSetAndAlarm() {
        AlarmClock alarmClock = new AlarmClock();

        //Define e verifica um alarme
        alarmClock.setAlarm("Reunião", "09:00");
        assertEquals("Reunião", alarmClock.getEvent("09:00"));
    }
    @Test
    public void testCancelAlarm() {
        AlarmClock alarmClock = new AlarmClock();

        alarmClock.setAlarm("Reunião", "09:00");

        //Cancela o alarme e verifica
        alarmClock.cancelAlarm("Reunião");
        assertNotEquals("Reunião", alarmClock.getEvent("09:00"));
    }
}