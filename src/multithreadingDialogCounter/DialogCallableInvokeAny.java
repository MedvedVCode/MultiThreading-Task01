package multithreadingDialogCounter;

import java.util.List;
import java.util.concurrent.*;

public class DialogCallableInvokeAny {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        CallAnswer answer = threadPool.invokeAny(
                List.of(new MyCallable(), new MyCallable(), new MyCallable(), new MyCallable())
        );

         System.out.println(answer);
        threadPool.shutdown();
    }
}
