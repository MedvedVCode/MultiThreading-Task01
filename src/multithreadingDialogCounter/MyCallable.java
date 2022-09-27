package multithreadingDialogCounter;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<CallAnswer> {

    @Override
    public CallAnswer call() {
        int repeats = 0;
        try {
            while (!Thread.currentThread().isInterrupted() && repeats < 5) {
                Thread.sleep(2000);
                System.out.println("Всем привет! Пишет вам " + Thread.currentThread().getName());
                repeats++;
            }
        } catch (InterruptedException e) {
            return new CallAnswer(repeats, Thread.currentThread().getName());
        }
        return new CallAnswer(repeats, Thread.currentThread().getName());
    }
}
