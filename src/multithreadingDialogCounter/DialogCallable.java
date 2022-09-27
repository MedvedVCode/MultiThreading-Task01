package multithreadingDialogCounter;

import java.util.concurrent.*;

public class DialogCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<CallAnswer> callService = () -> {
            int repeats = 0;
            for (int i = 0; i < 6; i++) {
                Thread.sleep(2000);
                System.out.println("Всем привет! Пишет вам " + Thread.currentThread().getName());
                repeats++;
            }
            return new CallAnswer(repeats, Thread.currentThread().getName());
        };

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final Future<CallAnswer> task = threadPool.submit(callService);
        final Future<CallAnswer> task1 = threadPool.submit(callService);
        final Future<CallAnswer> task2 = threadPool.submit(callService);
        final Future<CallAnswer> task3 = threadPool.submit(callService);

        System.out.println(task.get());
        System.out.println(task1.get());
        System.out.println(task2.get());
        System.out.println(task3.get());

        threadPool.shutdown();
    }
}
