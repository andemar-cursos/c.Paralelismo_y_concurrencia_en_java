package unsafe2;

public class Unsafe {

    public static void main(String[] args) {

        UnsafeCounter counter = new UnsafeCounter();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Task(counter, 10));
            threads[i].start();
        }

        for (Thread thread :
                threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Invoke 10 threads with count 10, total count should be 100");
        System.out.println("Total count was " + counter.getCount());
    }
}
