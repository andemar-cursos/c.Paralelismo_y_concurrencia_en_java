package queue;

import java.util.concurrent.*;

public class Queue {

    private static final int CONSUMERS = 5;
    private static final int QUEUE_SIZE = 30;

    public static void main(String[] args) {


        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(CONSUMERS);
        BlockingQueue<Message> queue =
                new PriorityBlockingQueue<>(QUEUE_SIZE, new Priority());

        for (int i = 0; i < CONSUMERS; i++) {
            executor.execute(new Task(queue));
        }

        try {
            for (int i = 0; i <= QUEUE_SIZE; i++) {
                queue.put(new Message("MESSAGE " + i, (i%3) + 1 ));
            }

            TimeUnit.SECONDS.sleep(2);
            executor.shutdown();
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Queue size: " + queue.size());
    }
}
