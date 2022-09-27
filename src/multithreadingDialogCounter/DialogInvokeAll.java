package multithreadingDialogCounter;

import java.util.List;
import java.util.concurrent.*;

public class DialogInvokeAll {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<CallAnswer>> answerList = threadPool.invokeAll(
                List.of(new MyCallable(), new MyCallable(), new MyCallable(), new MyCallable()), 6, TimeUnit.SECONDS
        );

        for (Future<CallAnswer> answerTask : answerList) {
//            if (answerTask.isCancelled()) {
//                System.out.println("Задание отменено!");
//            } else {
                System.out.println(answerTask.get());
  //          }
        }
        threadPool.shutdown();
    }
}
