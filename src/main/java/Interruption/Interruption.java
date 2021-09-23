package Interruption;

public class Interruption {

    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("Task Group");

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(group, new Task(), "Thread " + i);
            thread.start();
        }

        // Interrumbe todos los Thread's que esten en el grupo
        group.interrupt();

        System.out.println("Finished " + Thread.currentThread().getName());
    }
}
