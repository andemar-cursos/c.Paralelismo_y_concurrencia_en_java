package executors_interrupt;

public class Task implements Runnable {

    private Long num;

    public Task(Long num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            num = veryInefficientFibonacci(num);
            System.out.println(Thread.currentThread().getName() + " obtained " + num);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }

    }

    private Long veryInefficientFibonacci(Long n) throws InterruptedException {

        if(Thread.interrupted()) {
            throw new InterruptedException();
        } else {
            if (n == 0 || n == 1) {
                return n;
            } else {
                return veryInefficientFibonacci(n - 2) + veryInefficientFibonacci(n - 1);
            }
        }
    }
}
