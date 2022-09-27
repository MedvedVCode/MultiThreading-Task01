package averageSumUsualAndThreads;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class AverageSumArray {
    public static Instant begin;
    public static Instant end;
    public static int arraySize = 100_000_000;
    public static int lowLimit = 0;
    public static int upperLimit = 30;


    public static void main(String[] args) {

        int[] array = new int[arraySize];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(lowLimit, upperLimit);
        }
        System.out.printf("\nМассив размером %d, рандом от %d до %d\n", arraySize, lowLimit, upperLimit);

        long sum = 0;
        begin = Instant.now();
        for (int j : array) {
            sum += j;
        }
        end = Instant.now();
        printResult("Цикл", sum);

        begin = Instant.now();
        SumCounter sumCounter = new SumCounter(array);
        ForkJoinPool fork = new ForkJoinPool();
        sum = fork.invoke(sumCounter);
        end = Instant.now();
        printResult("ForkJoinPool", sum);

        sum = 0;
        begin = Instant.now();
        sum = reversedSum(array);
        end = Instant.now();
        printResult("Сумма в простой рекурсии", sum);

    }

    private static long reversedSum(int[] array) {
        if (array.length <= 2) {
            return Arrays.stream(array).sum();
        } else {
            return reversedSum(Arrays.copyOfRange(array, 0, array.length / 2)) +
                    reversedSum(Arrays.copyOfRange(array, array.length / 2, array.length));
        }

    }

    private static void printResult(String str, long sum) {
        System.out.printf("%s, сумма %d, среднее арифметическое %d, время %d\n",
                str, sum, sum / arraySize, Duration.between(begin, end).toMillis());
    }
}
