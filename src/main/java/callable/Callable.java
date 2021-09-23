package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Callable {

    private static final long N = 5000L;
    private static final int TASKS = 5;

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(TASKS);
        List<Future<Long>> results = new ArrayList<>(TASKS);

        for (int i = 0; i < TASKS; i++) {
            java.util.concurrent.Callable<Long> task = new Task(N);
            Future<Long> result = executor.submit(task);
            results.add(result);
        }

        for (Future<Long> result :
                results) {
            try {
                System.out.println("Obtained result: " + result.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        System.out.println("Executor was successfully terminated");
    }
}
