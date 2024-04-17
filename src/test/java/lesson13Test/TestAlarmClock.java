package lesson13Test;

import Lesson13.AlarmClock;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAlarmClock {
    @Test
    public void testSetAlarm() {
        AlarmClock alarmClock = new AlarmClock();

        //Define um alarme para uma reunião às 9:00
        alarmClock.setAlarm("Reunião", "09:00");
        //Verifica se o evento associado ao horário 9:00 é Reunião
        assertEquals("Reunião", alarmClock.getEvent("09:00"));
    }
    @Test
    public void testCheckAlarms() {
        AlarmClock alarmClock = new AlarmClock();

        //Redireciona a saída padrão para capturar a impressão do método checkAlarms
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        alarmClock.setAlarm("Reunião","10:00");

        //Testa o método checkAlarms para o horário especificado
        alarmClock.checkAlarms("10:00");

        //Verifica se a saída contém a mensagem esperada
        assertTrue(outputStream.toString().contains("Alarm for Reunião!"));
    }
}
