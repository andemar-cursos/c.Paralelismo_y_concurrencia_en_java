package barriers;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Barriers {

    private static final int TASKS = 5;
    private static final int NUMBERS = 5000;

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(TASKS);
        AtomicIntegerArray partialSums = new AtomicIntegerArray(TASKS);
        Random random = new Random();

        CyclicBarrier barrier = new CyclicBarrier(TASKS, new ReductionTask(partialSums));

        for (int i = 0; i < TASKS; i++) {
            int[] nubmers = random.ints(NUMBERS, 0, 10).toArray();
            executor.execute(new Task(i, nubmers, barrier, partialSums));
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }
        executor.shutdownNow();
    }
}
