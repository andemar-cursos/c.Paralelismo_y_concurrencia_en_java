package cache;

public class NoCacheLocal {

    private static volatile Boolean isFinished = false;

    public static void main(String[] args) {

        new Thread(() -> {
            while(!isFinished) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Task finished.");
        }).start();

        isFinished = true;
        System.out.println("Main finished");

    }
}
