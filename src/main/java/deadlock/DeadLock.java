package deadlock;

public class DeadLock {

    // OK
    public static void main2(String[] args) {
        Object resource1 = new Object(), resource2 = new Object();
        new Thread(new Task(resource1, resource2)).start();
        new Thread(new Task(resource1, resource2)).start();
    }

    // Fails
    public static void main(String[] args) {
        Object resource1 = new Object(), resource2 = new Object();
        new Thread(new Task(resource1, resource2)).start();
        new Thread(new Task(resource2, resource1)).start();
    }
}
