package clock;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.assertEquals;

public class ClockTest {
    private Clock clock;
    private Lock lock;
    private Condition receivedEnoughTics;

    protected void setUp() {
        lock = new ReentrantLock();
        receivedEnoughTics = lock.newCondition();
    }
    @Test
    public void testClock() throws Exception {
        final int seconds = 2;
        final List<Date> tics = new ArrayList<Date>();
        ClockListener listener = createClockListener(tics);
        clock = new Clock() {
            @Override
            public ZoneId getZone() {
                return null;
            }

            @Override
            public Clock withZone(ZoneId zone) {
                return null;
            }

            @Override
            public Instant instant() {
                return null;
            }
        };
        lock.lock();
        try {
            receivedEnoughTics.await();
        } finally {
            lock.unlock();
        }

//        clock.stop();
//        verify(tics);
    }
    private void verify(List<Date> tics) {
        assertEquals(5, tics.size());
        for (int i = 1; i < 5; i++)
            assertEquals(1, getSecondsFromLast(tics));
    }
    private ClockListener createClockListener(
            final List<Date> tics) {
        return new ClockListener() {
            private int count = 0;

            public void update(Date date) {
                tics.add(date);
                if (++count == 2) {
                    lock.lock();
                    try {
                        receivedEnoughTics.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
    }
    private long getSecondsFromLast(List<Date> tics) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(tics.get(1));
        int now = calendar.get(Calendar.SECOND);
        calendar.setTime(tics.get(0));
        int then = calendar.get(Calendar.SECOND);
        if (now == 0)
            now = 60;
        return now - then;
    }
}

