package concurrency_in_practice.brian_goetz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorNonSyncExample {
    static int count = 0;

    public static void increment() {
        count++;
    }


    public static void main(String[] args) {
        ExecutorService  executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000).forEach(i -> executor.submit(ExecutorNonSyncExample::increment));

        executor.shutdown();
        try {
            executor.awaitTermination(600, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Exception caught " + e);
        }
        System.out.println(count);
    }
}
