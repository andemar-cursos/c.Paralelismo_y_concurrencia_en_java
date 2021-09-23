package wait_and_notify;

public class WaitAndNotify {

    public static void main(String[] args) {

        Object object = new Object();
        new Thread(new Task(object)).start();
        new Thread(new Task(object)).start();

        try {
            System.out.println("Main Thread go to Sleep for 5s");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " woke up from sleep, notifying the others threads..");
            object.notifyAll();
        }
        System.out.println("Finished " + Thread.currentThread().getName());
    }
}
