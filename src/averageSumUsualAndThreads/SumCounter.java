package averageSumUsualAndThreads;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SumCounter extends RecursiveTask<Integer> {
    private int[] array;

    public SumCounter(int[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if (array.length <= 2) {
            return Arrays.stream(array).sum();
        }
        SumCounter firstHalfArray = new SumCounter(Arrays.copyOfRange(array, 0, array.length / 2));
        SumCounter secondHalfArray = new SumCounter(Arrays.copyOfRange(array, array.length / 2, array.length));
        firstHalfArray.fork();
        secondHalfArray.fork();
        return firstHalfArray.join() + secondHalfArray.join();
    }
}
