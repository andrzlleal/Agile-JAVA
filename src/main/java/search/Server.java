package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server extends Thread{
    private final BlockingQueue<Search> queue = new LinkedBlockingQueue<Search>();
    private final ResultsListener listener;
    static final String START_MSG = "started";
    static final String END_MSG = "finished";
    private static final ThreadLocal<List<String>> threadLog = new ThreadLocal<List<String>>() {
        protected List<String> initialValue() {
            return new ArrayList<String>();
        }
    };
    private final List<String> completeLog =
            Collections.synchronizedList(new ArrayList<String>());

    public List<String> getLog() {
        return completeLog;
    }
    public Server(ResultsListener listener) {
        this.listener = listener;
        start();
    }
    public void run() {
        while (true) {
            try {
                execute(String.valueOf(queue.take()));
            } catch (InterruptedException ignored) {
                break;
            }
        }
    }
    public void add(Search search) throws Exception{
        queue.put(search);
    }
    private void execute(final String search) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                log(START_MSG, search);
                //search.execute();
                log(END_MSG, search);
                listener.executed(search);
                completeLog.addAll(threadLog.get());
            }
        });
        thread.setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread th, Throwable thrown) {
                        completeLog.add(search + " " + thrown.getMessage());
                        listener.executed(search);
                    }
                }
        );
        thread.start();
    }
    private void log(String message, String search) {
        threadLog.get().add(
                search + " " + message + " at " + new Date());
    }
    public void shutDown () throws Exception {
        this.interrupt();
    }
}
