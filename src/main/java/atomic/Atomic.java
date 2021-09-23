package atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Atomic {

    private static final int TASKS = 10;
    private static final long WAITING_TIME = 5;
    private static final long INITIAL_BALANCE = 100000L;

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(TASKS);
        Account account = new Account(INITIAL_BALANCE);

        List<Future<Long>> results = new ArrayList<>(TASKS);
        for (int i = 0; i <= TASKS; i++) {
            results.add(executor.submit(new BankingTask(account)));
        }

        Long finalBalance = INITIAL_BALANCE;
        try {
            TimeUnit.SECONDS.sleep(WAITING_TIME);
            executor.shutdownNow();

            for (Future<Long> result :
                    results) {
                finalBalance += result.get();
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance was " + account.getBalance() +
                " and shoult be " + finalBalance);

    }
}
